/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.servicios;

import ec.edu.espe.distribuidas.factnosql.modelo.Factura;
import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.PersonasSum;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
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
    
    public List<PersonasSum> sumarizadoPersonas()
    {
        Iterator<PersonasSum> aggregate = persistence.context().createAggregation(Factura.class).group("persona",Group.grouping("count",new Accumulator("$sum", 1)),Group.grouping("cedula",Group.first("valor")) ).aggregate(PersonasSum.class);
        List<PersonasSum> presonasS= IteratorUtils.toList(aggregate);
        for(PersonasSum p : presonasS)
            System.out.println(p);
        Query q = persistence.context().createQuery(Persona.class);
        List<Persona> personas = q.asList();
        
        for(Persona p: personas)
        {
            boolean flag=true;
            for(int i=0;i<presonasS.size();i++)
            {
                if(p.getCedula().equals(presonasS.get(i).getCedula()))
                {
                    flag=false;
                    presonasS.get(i).setPersona(p);
                }
            }
            if(flag)
                presonasS.add(new PersonasSum(p, 0, p.getCedula()));
        }
        
        return presonasS;
    }
   
}
