/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

/**
 *
 * @author ale
 */
public class ProductoServicio {
    
    private PersistenceManager persistence;

    public ProductoServicio() {
        persistence = new PersistenceManager();
    }
    
    public Producto buscarProductoPorCodigo(String codigo)
    {
        Query q = persistence.context().createQuery(Producto.class);
        q.filter("codigo", codigo);
        Producto p =null;
        if(q.asList().size()>0)
            p = (Producto)q.asList().get(0);
        return p;
    }
    
    public void actualizarStockProducto(Producto producto, Integer cantidadRestada){
        
        Query q = persistence.context().createQuery(Producto.class);
        q.filter("codigo", producto.getCodigo());
        Producto p =null;
        if(q.asList().size()>0)
            p = (Producto)q.asList().get(0);
        
        UpdateOperations<Producto> ops;
        ops = persistence.context().createUpdateOperations(Producto.class).set("stock", cantidadRestada);
        persistence.context().update(q, ops);        
    }
    
    
}
