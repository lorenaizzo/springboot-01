package ar.com.smartsol.prueba01.spring_boot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private String apellido;
    
    public Integer getId() {return this.id;}
    public String getNombre() {return this.nombre;}
    public String getApellido() {return this.apellido; }
    public void setId(Integer value) {this.id = value;}
    public void setNombre(String value) {this.nombre = value;}
    public void setApellido(String value) {this.apellido = value;}

}