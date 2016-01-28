/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.CountResult;
import ec.edu.espe.distribuidas.factnosql.modelo.DetalleFactura;
import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.Sequence;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.mongodb.morphia.aggregation.Accumulator;
import static org.mongodb.morphia.aggregation.Group.grouping;
import org.mongodb.morphia.aggregation.Sort;
import org.mongodb.morphia.query.Query;

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
    
    public void guardarFactura(List<DetalleFactura> detalle, Persona persona)
    {
        float total =0;
        for(DetalleFactura df:detalle)
        {
            total+=(df.getCantidad()*df.getProducto().getPrecio());
        }
        Date fechaActual = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        calendar.set(Calendar.MILLISECOND, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        this.persistence.context().save(new Factura(this.getNext("factura"), calendar.getTime(),total, persona, detalle));
    }
    
    
    
    public List<CountResult> totalFacturasDiarias()
    {
        Iterator<CountResult> aggregation = persistence.context().
                createAggregation(Factura.class)
                .group("fechaEmision", grouping("count", new Accumulator("$sum", "total")))
                .sort(Sort.ascending("_id"))
                .aggregate(CountResult.class);

        List<CountResult> lista= new ArrayList<>();
        CountResult result1;
        while (aggregation.hasNext()) {
            result1 = aggregation.next();
            lista.add(result1);
        }
        
        return lista;
    }
    
    
    
}
