/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.ProductoSum;
import ec.edu.espe.distribuidas.factnosql.servicios.PersonaServicio;
import ec.edu.espe.distribuidas.factnosql.servicios.ProductoServicio;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author RAUL
 */
@ManagedBean
@ViewScoped
public class SumarizadoProductosBean {
    private ProductoServicio productoServicio;
    private List<ProductoSum> productos;
    private Date fecha;

    public List<ProductoSum> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoSum> productos) {
        this.productos = productos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
    @PostConstruct
    public void inicializar()
    {
        this.productoServicio = new ProductoServicio();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        fecha=new Date();
        try {
            this.productos = this.productoServicio.sumarizadoProductosPorFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SumarizadoProductosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void cargar()
    {
        try {
            this.productos = this.productoServicio.sumarizadoProductosPorFecha(fecha);
        } catch (ParseException ex) {
            Logger.getLogger(SumarizadoProductosBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
