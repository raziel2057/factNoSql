/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.DetalleFactura;
import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.Sequence;
import ec.edu.espe.distribuidas.factnosql.modelo.VentasDiarias;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.Group;

/**
 *
 * @author RAUL
 */
public class FacturaServicio {
    private PersistenceManager persistence;

    public FacturaServicio() {
        persistence = new PersistenceManager();
    }
    
    public Integer getNext(String collection) {
        Sequence seq = persistence.context().findAndModify(
            persistence.context().find(Sequence.class, "key = ", collection), // query
            persistence.context().createUpdateOperations(Sequence.class).inc("counter") // update
          );

          // create a sequence record for your collection if not found
          if(seq == null) {
              seq = new Sequence(collection, 1);
              persistence.context().save(seq);
          }

         return seq.getCounter();
      }
    
    public void guardarFactura(List<DetalleFactura> detalle, Persona persona) throws ParseException
    {
        float total =0;
        for(DetalleFactura df:detalle)
        {
            total+=(df.getCantidad()*df.getProducto().getPrecio());
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.persistence.context().save(new Factura(this.getNext("factura"),sdf.parse(sdf.format( new Date())),total,persona.getCedula(), persona, detalle));
    }
    
    public List<VentasDiarias> totalVentasDiarias()
    {
        Iterator<VentasDiarias> aggregate = persistence.context().createAggregation(Factura.class)
                    .group("fechaEmision",Group.grouping("total",Group.sum("total")),Group.grouping("count",new Accumulator("$sum", 1)),Group.grouping("fechaEmision",Group.first("fechaEmision")) )
                .aggregate(VentasDiarias.class);
        List<VentasDiarias> totalVentas= IteratorUtils.toList(aggregate);
        for(VentasDiarias p : totalVentas)
            System.out.println(p);
        
        return totalVentas;
    }
}
