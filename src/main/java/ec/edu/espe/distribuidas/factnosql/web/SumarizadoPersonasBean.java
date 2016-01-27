/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.PersonasSum;
import ec.edu.espe.distribuidas.factnosql.servicios.FacturaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.PersonaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.ProductoServicio;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class SumarizadoPersonasBean {
    private PersonaServicio personaServicio;
    private List<PersonasSum> personas;

    public List<PersonasSum> getPersonas() {
        return personas;
    }

    public void setPersonas(List<PersonasSum> personas) {
        this.personas = personas;
    }
    
     @PostConstruct
    public void inicializar()
    {
        this.personaServicio = new PersonaServicio();
        this.personas = this.personaServicio.sumarizadoPersonas();
    }
}
