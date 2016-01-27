/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

/**
 *
 * @author RAUL
 */
public class Id {
    private PersonaRef persona;

    public Id() {
    }

    public Id(PersonaRef persona) {
        this.persona = persona;
    }

    public PersonaRef getPersona() {
        return persona;
    }

    public void setPersona(PersonaRef persona) {
        this.persona = persona;
    }

    @Override
    public String toString() {
        return "Id{" + "persona=" + persona + '}';
    }
    
}
