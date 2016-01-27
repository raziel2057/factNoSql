/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import ec.edu.espe.distribuidas.factnosql.persistencia.BaseEntity;
import org.mongodb.morphia.annotations.Entity;

/**
 *
 * @author RAUL
 */
@Entity(value="sequence")
public class Sequence extends BaseEntity{
    private String key;
    private Integer counter;

    public Sequence() {
    }

    public Sequence(String factura, Integer counter) {
        this.key = factura;
        this.counter = counter;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Sequence{" + "factura=" + key + ", counter=" + counter + '}';
    }
    
    
}
