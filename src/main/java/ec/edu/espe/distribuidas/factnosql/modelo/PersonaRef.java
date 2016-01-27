/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.distribuidas.factnosql.modelo;

import java.io.Serializable;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 *
 * @author RAUL
 */
@Entity
public class PersonaRef extends Object
implements Serializable {
    private String ref;
   @Id
    private ObjectId id;

    public PersonaRef() {
    }

    public PersonaRef(String ref, ObjectId id) {
        this.ref = ref;
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonaRef{" + "ref=" + ref + ", id=" + id + '}';
    }
    
}
