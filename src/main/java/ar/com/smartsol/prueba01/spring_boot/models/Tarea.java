package ar.com.smartsol.prueba01.spring_boot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Boolean terminada;

    public String getNombre() {return this.nombre;}
    public Boolean getTerminada() {return this.terminada; }
    public void setNombre(String value) {this.nombre = value;}
    public void setTerminada(Boolean value) {this.terminada = value;}

}