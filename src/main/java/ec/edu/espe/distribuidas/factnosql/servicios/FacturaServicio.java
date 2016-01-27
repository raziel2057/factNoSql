/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;

/**
 *
 * @author ale
 */
public class FacturaServicio {
    
    private PersistenceManager persistence;

    public FacturaServicio() {
        persistence = new PersistenceManager();
    }
    
    public void insertarFactura(Factura factura){
        persistence.context().save(factura);
    }
    
}
