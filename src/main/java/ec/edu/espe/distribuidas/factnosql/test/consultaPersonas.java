/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.test;



import ec.edu.espe.distribuidas.factnosql.modelo.Factura;

import ec.edu.espe.distribuidas.factnosql.modelo.PersonasSum;
import ec.edu.espe.distribuidas.factnosql.modelo.ProductoSum;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.mongodb.morphia.aggregation.Accumulator;

import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author RAUL
 */
public class consultaPersonas {
    
    
    public static void main(String[] args) throws ParseException {
        PersistenceManager persistence = new PersistenceManager();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query q = persistence.context().createQuery(Factura.class).field("fechaEmision").equal(sdf.parse("2016-01-27"));
        Iterator<ProductoSum> aggregate = persistence.context().createAggregation(Factura.class)
                .match(q)
                .unwind("detalle")
                    .group("detalle.producto",Group.grouping("count",Group.sum("detalle.cantidad")),Group.grouping("fecha",Group.first("fechaEmision")),Group.grouping("codigo",Group.first("detalle.codigo")) )
                .aggregate(ProductoSum.class);
        List<ProductoSum> presonasS= IteratorUtils.toList(aggregate);
        for(ProductoSum p : presonasS)
            System.out.println(p);
      
    }
    
}
