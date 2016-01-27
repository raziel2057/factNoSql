/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.DetalleFactura;
import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.servicios.FacturaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.PersonaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.ProductoServicio;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class RegistroFacturaBean implements Serializable{
    private PersonaServicio personaServicio;
    private ProductoServicio productoServicio;
    private FacturaServicio facturaServicio;
    private String cedula;
    private Persona persona;
    private List<Producto> productos;
    private String codigoProducto;
    private List<DetalleFactura> detalle;
    private float totalFactura;

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

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public List<DetalleFactura> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<DetalleFactura> detalle) {
        this.detalle = detalle;
    }

    public float getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(float totalFactura) {
        this.totalFactura = totalFactura;
    }
    
    
    
    @PostConstruct
    public void inicializar()
    {
        this.personaServicio = new PersonaServicio();
        this.productoServicio = new ProductoServicio();
        this.facturaServicio = new FacturaServicio();
        detalle=new ArrayList<>();
        this.cargarProductos();
        this.totalFactura=0;
        //this.persona=new Persona();
    }
    
    public void buscarPersona()
    {
        
        this.persona=this.personaServicio.buscarPersonaPorCedula(cedula);
    }
    
    public void cargarProductos()
    {
        this.productos=this.productoServicio.buscarTodos();
    }
    
    public void agregarDetalle()
    {
        boolean flag=true;
        for(int i=0;i<this.detalle.size();i++)
        {
            if(this.detalle.get(i).getProducto().getCodigo().equals(this.codigoProducto))
            {
                flag=false;
                this.detalle.get(i).setCantidad(this.detalle.get(i).getCantidad()+1);
                this.totalFactura+=this.detalle.get(i).getProducto().getPrecio();
                break;
            }
        }
        if(flag)
        {
            for(Producto p: productos)
            {
                if(p.getCodigo().equals(this.codigoProducto))
                {
                    this.detalle.add(new DetalleFactura(p, 1,p.getCodigo()));
                    this.totalFactura+=p.getPrecio();
                    break;
                }
            }
        }
    }
    
    public void guardarFactura() throws ParseException
    {
        this.facturaServicio.guardarFactura(detalle, persona);
        this.reset();
    }
    
    public void reset()
    {
        this.detalle = new ArrayList<>();
        this.persona=null;
        this.cedula=null;
        this.totalFactura=0;
    }
    
}
