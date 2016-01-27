/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;


import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.modelo.ProductoSum;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.collections.IteratorUtils;
import org.mongodb.morphia.aggregation.Group;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author RAUL
 */
public class ProductoServicio {
    private PersistenceManager persistence;

    public ProductoServicio() {
        persistence = new PersistenceManager();
    }
    
    public List<Producto> buscarTodos()
    {
        List<Producto> productos;
        Query q = persistence.context().createQuery(Producto.class);
        productos = q.asList();
        return productos;
    }
    
    public List<ProductoSum> sumarizadoProductosPorFecha(Date fecha) throws ParseException
    {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Query q = persistence.context().createQuery(Factura.class).field("fechaEmision").equal(sdf.parse(sdf.format(fecha)));
        Iterator<ProductoSum> aggregate = persistence.context().createAggregation(Factura.class)
                .match(q)
                .unwind("detalle")
                    .group("detalle.producto",Group.grouping("count",Group.sum("detalle.cantidad")),Group.grouping("fecha",Group.first("fechaEmision")),Group.grouping("codigo",Group.first("detalle.codigo")) )
                .aggregate(ProductoSum.class);
        List<ProductoSum> productosS= IteratorUtils.toList(aggregate);
        for(ProductoSum p : productosS)
            System.out.println(p);
        Query q2 = persistence.context().createQuery(Producto.class);
        List<Producto> productos = q2.asList();
        
        for(Producto p:productos)
        {
            for(int i=0;i<productosS.size();i++)
            {
                if(p.getCodigo().equals(productosS.get(i).getCodigo()))
                {
                    productosS.get(i).setProducto(p);
                }
            }
        }
        
        return productosS;
    }
}
