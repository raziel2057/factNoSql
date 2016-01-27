/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.DetalleFactura;
import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.servicios.PersonaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.ProductoServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ale
 */
@ManagedBean
@ViewScoped
public class FacturaBean implements Serializable {

    private PersonaServicio personaServicio;
    private ProductoServicio productoServicio;

    private String cedula;
    private Persona persona;

    private String codigo;
    private Integer cantidad;
    private Producto producto;
    private List<DetalleFactura> detalleFactura;
    
    private float total;

    private boolean enFactura;

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

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public boolean isEnFactura() {
        return enFactura;
    }

    public void setEnFactura(boolean enFactura) {
        this.enFactura = enFactura;
    }

    public List<DetalleFactura> getDetalleFactura() {
        return detalleFactura;
    }

    public void setDetalleFactura(List<DetalleFactura> detalleFactura) {
        this.detalleFactura = detalleFactura;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    
    public FacturaBean() {
        this.personaServicio = new PersonaServicio();
        this.productoServicio = new ProductoServicio();
    }

    public void buscarPersona() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.persona = this.personaServicio.buscarPersonaPorCedula(cedula);

        if (this.persona != null) {
            this.enFactura = true;
            this.detalleFactura = new ArrayList<>();
            this.total=0;
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encontro cliente", null));
        }

    }

    public void agregarProducto() {
        FacesContext context = FacesContext.getCurrentInstance();
        this.producto = this.productoServicio.buscarProductoPorCodigo(this.codigo);

        if (this.producto != null) {
            if (this.producto.getStock() >= this.cantidad) {
                detalleFactura.add(new DetalleFactura(this.producto, this.cantidad));
                this.productoServicio.actualizarStockProducto(this.producto, this.cantidad);
                this.total=this.total+this.producto.getPrecio()*this.cantidad;
            } else {
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Cantidad de "+cantidad.toString()+
                        " supera el stock de "+this.producto.getStock(), null));
            }
        } else {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "No se encontro el producto", null));

        }

    }
    
    public void registrarFactura(){
        
    }

}
