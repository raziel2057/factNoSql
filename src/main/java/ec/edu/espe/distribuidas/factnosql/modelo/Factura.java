/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import ec.edu.espe.distribuidas.factnosql.persistencia.BaseEntity;
import java.util.Date;
import java.util.List;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

/**
 *jjlhk
 * @author RAUL
 */
@Entity(value="factura")
public class Factura extends BaseEntity {
    private Integer codigo;
    private Date fechaEmision;
    private float total;
    
    @Reference
    private Persona persona;
    @Embedded
    private List<DetalleFactura> detalle;

    public Factura() {
    }

    public Factura(Integer codigo, Date fechaEmision, float total, Persona persona, List<DetalleFactura> detalle) {
        this.codigo = codigo;
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.persona = persona;
        this.detalle = detalle;
    }



    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
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

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Factura{" + "codigo=" + codigo + ", fechaEmision=" + fechaEmision + ", total=" + total + ", persona=" + persona + ", detalle=" + detalle + '}';
    }


  
    
    
}
