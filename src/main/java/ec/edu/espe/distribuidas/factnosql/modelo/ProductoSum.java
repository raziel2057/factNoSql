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
public class ProductoSum {
    public Producto producto;
    public Date fecha;
    public String codigo;
    public Integer count;

    public ProductoSum() {
    }

    public ProductoSum(Producto producto, Date fecha, String codigo, Integer count) {
        this.producto = producto;
        this.fecha = fecha;
        this.codigo = codigo;
        this.count = count;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ProductoSum{" + "producto=" + producto + ", fecha=" + fecha + ", codigo=" + codigo + ", count=" + count + '}';
    }
    
    
}
