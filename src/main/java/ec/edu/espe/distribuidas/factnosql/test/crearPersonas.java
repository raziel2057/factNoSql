/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.test;

import ec.edu.espe.distribuidas.factnosql.modelo.Persona;
import ec.edu.espe.distribuidas.factnosql.persistencia.PersistenceManager;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author RAUL
 */
public class crearPersonas {
    public static void main(String[] args) {
        PersistenceManager persistence = new PersistenceManager();
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona("1234567890", "Raul Naranjo", "Sangolqui - La Colina", "0994874863", "raul@gmail.com"));
        personas.add(new Persona("1234567891", "Alejandra Ponce", "Sangolqui - Centro", "0997856123", "ale@gmail.com"));
        personas.add(new Persona("1234567892", "Luis Guerrero", "Quito - Yaruqui", "0984578963", "luis@gmail.com"));
        personas.add(new Persona("1234567893", "Vanesa Nasimba", "Quito - La Marin", "0987485962", "vanesa@gmail.com"));
        personas.add(new Persona("1234567894", "Andres Liger", "Quito - Quitumbe", "0954785963", "andres@gmail.com"));
        personas.add(new Persona("1234567895", "Dennys Quiroz", "Sangolqui - Puente 9", "0978541230", "dennys@gmail.com"));
        personas.add(new Persona("1234567896", "Dalia Gordon", "Quito - La Luz", "0994874852", "dalia@gmail.com"));
        personas.add(new Persona("1234567897", "Paola Montufar", "Amaguaña", "0994785210", "paola@gmail.com"));
        personas.add(new Persona("1234567898", "Cristina Baez", "Sangolqui - La Colina", "0997848963", "cris@gmail.com"));
        personas.add(new Persona("1234567899", "Paul Lopez", "Sangolqui - La Colina", "0997485210", "paul@gmail.com"));
        
        for(Persona p : personas)
            persistence.context().save(p);
    }
}
