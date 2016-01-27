/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.test;

import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.modelo.PersonasSum;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.mongodb.morphia.aggregation.Accumulator;
import org.mongodb.morphia.aggregation.Group;

/**
 *
 * @author RAUL
 */
public class consultarProductos {
    public static void main(String[] args) {
        PersistenceManager persistence = new PersistenceManager();
        
        Iterator<PersonasSum> aggregate = persistence.context().createAggregation(Factura.class).group("persona",Group.grouping("count",new Accumulator("$sum", 1)),Group.grouping("cedula",Group.first("valor")),Group.grouping("persona",Group.first("persona")) ).aggregate(PersonasSum.class);
        List<PersonasSum> presonasS= IteratorUtils.toList(aggregate);
        for(PersonasSum p : presonasS)
            System.out.println(p);
      
    }
}
