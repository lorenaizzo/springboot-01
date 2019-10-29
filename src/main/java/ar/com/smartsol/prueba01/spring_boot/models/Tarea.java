package ar.com.smartsol.prueba01.spring_boot.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String nombre;
    private Boolean terminada;

    @ManyToOne
    private Persona personaAsignada;

    public Integer getId() {return this.id;}
    public String getNombre() {return this.nombre;}
    public Boolean getTerminada() {return this.terminada; }
    public Persona getPersonaAsignada() {return this.personaAsignada;}
    public void setId(Integer value) {this.id = value;}
    public void setNombre(String value) {this.nombre = value;}
    public void setTerminada(Boolean value) {this.terminada = value;}
    public void setPersonaAsignada(Persona value) { this.personaAsignada = value;}

}