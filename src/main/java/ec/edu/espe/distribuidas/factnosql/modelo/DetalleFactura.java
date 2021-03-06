/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import java.util.List;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Reference;

/**
 *
 * @author RAUL
 */
@Embedded
public class DetalleFactura {
    @Reference
    private Producto producto;
    private Integer cantidad;
    private String codigo;

    public DetalleFactura() {
    }

    public DetalleFactura(Producto producto, Integer cantidad, String codigo) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.codigo = codigo;
    }

    

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "DetalleFactura{" + "producto=" + producto + ", cantidad=" + cantidad + ", codigo=" + codigo + '}';
    }
    

    
    
}
