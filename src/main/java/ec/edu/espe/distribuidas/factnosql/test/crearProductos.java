/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.test;

import ec.edu.espe.distribuidas.factnosql.modelo.Producto;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAUL
 */
public class crearProductos {
    public static void main(String[] args) {
        PersistenceManager persistence = new PersistenceManager();
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("01", "Cereal", 2.37f, 30));
        productos.add(new Producto("02", "Docena Huevos", 2.05f, 35));
        productos.add(new Producto("03", "Aceite funda", 1.91f, 25));
        productos.add(new Producto("04", "Lata de Frejol", 1.38f, 30));
        productos.add(new Producto("05", "Lata de Arroz con Lentejas", 1.32f, 30));
        productos.add(new Producto("06", "Lata Sardina", 0.67f, 40));
        productos.add(new Producto("07", "Flan 80gr", 1.06f, 35));
        productos.add(new Producto("08", "Arroz 2Kg", 2.35f, 30));
        productos.add(new Producto("09", "Ensalada", 1.85f, 15));
        productos.add(new Producto("10", "Zanahoria Rallada", 1.02f, 16));
        productos.add(new Producto("11", "Pan Molde", 2.42f, 60));
        productos.add(new Producto("12", "Filetes de Pollo", 4.77f, 30));
        productos.add(new Producto("13", "Salsa de tomate", 0.76f, 42));
        productos.add(new Producto("14", "Mayonesa", 1.00f, 30));
        productos.add(new Producto("15", "Mortadela 100gr", 0.60f, 100));
        productos.add(new Producto("16", "Malla Papas 1Kg", 1.74f, 12));
        productos.add(new Producto("17", "Atun", 2.20f, 46));
        productos.add(new Producto("18", "Enjuague Bucal", 6.12f, 30));
        productos.add(new Producto("19", "Leche 1lt", 0.99f, 30));
        productos.add(new Producto("20", "Jabon", 1.06f, 30));
        
        for(Producto p : productos)
            persistence.context().save(p);
        
    }
}
