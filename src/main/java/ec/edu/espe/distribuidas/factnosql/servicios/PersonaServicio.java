/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import org.mongodb.morphia.query.Query;

/**
 *
 * @author RAUL
 */
public class PersonaServicio {
    private PersistenceManager persistence;

    public PersonaServicio() {
        persistence = new PersistenceManager();
    }
    
    public Persona buscarPersonaPorCedula(String cedula)
    {
        Query q = persistence.context().createQuery(Persona.class);
        q.filter("cedula", cedula);
        Persona p =null;
        if(q.asList().size()>0)
            p = (Persona)q.asList().get(0);
    
        return p;
    }
    
    
   
}
