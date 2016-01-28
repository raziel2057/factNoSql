/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.test;

import ec.edu.espe.distribuidas.factnosql.modelo.CountResult;
import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.mongodb.morphia.aggregation.Accumulator;
import static org.mongodb.morphia.aggregation.Group.grouping;
import org.mongodb.morphia.aggregation.Sort;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author ale
 */
public class prueba {

    public static void main(String[] args) {

        PersistenceManager persistence = new PersistenceManager();
        Iterator<CountResult> aggregation = persistence.context().
                createAggregation(Factura.class)
                .group("fechaEmision", grouping("count", new Accumulator("$sum", "total")))
                .sort(Sort.ascending("_id"))
                .aggregate(CountResult.class);

        Integer total=0;
        CountResult result1;
        while (aggregation.hasNext()) {
            total=total+1;
            result1 = aggregation.next();
            System.out.println("Fecha 1: "+result1.getFecha().toString()+" Total:"+result1.getCount());
        }
        
        System.out.println("Total: "+total);
        

    }

}
