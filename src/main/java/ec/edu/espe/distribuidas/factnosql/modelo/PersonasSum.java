/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import ec.edu.espe.distribuidas.factnosql.persistencia.BaseEntity;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author RAUL
 */

public class PersonasSum {
    @Reference
    private Persona persona;
    private Integer count;
    private String cedula;

    public PersonasSum() {
    }

    public PersonasSum(Persona persona, Integer count, String cedula) {
        this.persona = persona;
        this.count = count;
        this.cedula = cedula;
    }

    

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    @Override
    public String toString() {
        return "PersonasSum{" + "persona=" + persona + ", count=" + count + ", cedula=" + cedula + '}';
    }
    

    

    
    
    
}
