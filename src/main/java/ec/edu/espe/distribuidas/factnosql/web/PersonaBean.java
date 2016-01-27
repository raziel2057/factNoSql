/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.servicios.PersonaServicio;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class PersonaBean implements Serializable{
    private PersonaServicio personaServicio;
    private String cedula;
    private Persona persona;
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    
    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public PersonaBean() {
        

    }
    
    
    public void buscarPersona()
    {
        this.personaServicio = new PersonaServicio();
        this.persona=this.personaServicio.buscarPersonaPorCedula(cedula);

       
        
    }
    
}
