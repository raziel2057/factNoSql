/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import java.util.Date;

/**
 *
 * @author RAUL
 */
public class VentasDiarias {
    private Date fechaEmision;
    private float total;
    private Integer count;

    public VentasDiarias() {
    }

    public VentasDiarias(Date fechaEmision, float total, Integer count) {
        this.fechaEmision = fechaEmision;
        this.total = total;
        this.count = count;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "VentasDiarias{" + "fechaEmision=" + fechaEmision + ", total=" + total + ", count=" + count + '}';
    }
    
    
}
