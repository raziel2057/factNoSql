/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import ec.edu.espe.distribuidas.factnosql.persistencia.BaseEntity;
import java.util.Date;
import java.util.List;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author RAUL
 */
@Entity(value="factura")
public class Factura extends BaseEntity {
    private String codigo;
    private Date fechaEmision;
    private float total;
    
    @Reference
    private Persona persona;
    @Reference
    private List<Producto> productos;

    public Factura() {
    }

    public Factura(String codigo, Date fechaEmision, float total, Persona persona, List<Producto> productos) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.persona = persona;
        this.productos = productos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Date getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(Date fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", fechaEmision=" + fechaEmision + ", total=" + total + ", persona=" + persona + ", productos=" + productos + '}';
    }
    
    
    
}
