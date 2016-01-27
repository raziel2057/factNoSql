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
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.Date;
import java.util.List;

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
        
        this.persistence.context().save(new Factura(this.getNext("factura"), new Date(),total, persona, detalle));
    }
    
}
