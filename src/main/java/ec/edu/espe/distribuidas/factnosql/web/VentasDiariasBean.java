/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.VentasDiarias;
import ec.edu.espe.distribuidas.factnosql.servicios.FacturaServicio;
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
public class VentasDiariasBean {
    private FacturaServicio facturaServicio; 
    private List<VentasDiarias> ventas;

    public FacturaServicio getFacturaServicio() {
        return facturaServicio;
    }

    public void setFacturaServicio(FacturaServicio facturaServicio) {
        this.facturaServicio = facturaServicio;
    }

    public List<VentasDiarias> getVentas() {
        return ventas;
    }

    public void setVentas(List<VentasDiarias> ventas) {
        this.ventas = ventas;
    }
    
    @PostConstruct
    public void inicializar()
    {
        this.facturaServicio=new FacturaServicio();
        this.ventas=this.facturaServicio.totalVentasDiarias();
    }
}
