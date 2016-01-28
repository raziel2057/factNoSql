/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.web;

import ec.edu.espe.distribuidas.factnosql.modelo.CountResult;
import ec.edu.espe.distribuidas.factnosql.servicios.FacturaServicio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author ale
 */
@ManagedBean
@ViewScoped
public class VentasDiariasBean implements Serializable{
    
    private FacturaServicio facturaServicio;
    private List<CountResult> listaVentasDiarias;

    public List<CountResult> getListaVentasDiarias() {
        return listaVentasDiarias;
    }

    public void setListaVentasDiarias(List<CountResult> listaVentasDiarias) {
        this.listaVentasDiarias = listaVentasDiarias;
    }

    
    @PostConstruct
    public void Inicializar() {
        this.facturaServicio = new FacturaServicio();
        listaVentasDiarias=new ArrayList<>();
        listaVentasDiarias=facturaServicio.totalFacturasDiarias();
    }
 
}
