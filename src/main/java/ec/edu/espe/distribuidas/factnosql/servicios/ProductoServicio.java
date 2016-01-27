/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.List;
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
    
}
