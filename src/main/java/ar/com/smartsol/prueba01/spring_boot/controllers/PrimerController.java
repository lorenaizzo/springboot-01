package ar.com.smartsol.prueba01.spring_boot.controllers;

import java.lang.reflect.Array;
import java.lang.reflect.Field;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ar.com.smartsol.prueba01.spring_boot.models.Persona;
import ar.com.smartsol.prueba01.spring_boot.models.Tarea;
import ar.com.smartsol.prueba01.spring_boot.repositories.PersonaRepository;
import ar.com.smartsol.prueba01.spring_boot.repositories.TareaRepository;

@RestController
@RequestMapping("tareas")
public class PrimerController {

    @Autowired
    private TareaRepository tareaRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/")
    public Iterable<Tarea> listar() {
        return this.tareaRepository.findAll();
    }

    /**
     * Ejemplo de peticion
     * {
	 *      "nombre": "Ir de compras",
	 *      "terminada": false,
	 *      "personaAsignada": {
	 *	        "id": 2
	 *      }
     *  }
     * @param peticion
     * @return
     */
    @PostMapping("/")
    public  Tarea agregar(@RequestBody Tarea peticion) {
        tareaRepository.save(peticion);
        return peticion;
    }

    @GetMapping("/{id}")
    public Tarea obtener(@PathVariable Integer id) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        return tarea;
    }    

    /**
     * Ejemplo de peticion
     * {
	 *      "nombre": "Ir de compras",
	 *      "terminada": false,
	 *      "personaAsignada": {
	 *	        "id": 2
	 *      }
     *  }
     * @param id
     * @param peticion
     * @return
     */
    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Integer id, @RequestBody Tarea peticion) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        tarea.setNombre(peticion.getNombre());
        tarea.setTerminada(peticion.getTerminada());
        // Asignacion persona
        // Como solo se recibe el id de la persona => se deben obtener los demas datos de la base de datos
        // En caso que no se pueda actualizar la persona asignada a una tarea esto no hace falta
        Persona personaNueva = this.personaRepository.findById(peticion.getPersonaAsignada().getId()).orElse(null);
        tarea.setPersonaAsignada(personaNueva);
        // /Asignacion persona
        tareaRepository.save(tarea);
        return tarea;
    } 

    @DeleteMapping("/{id}")
    public Tarea borrar(@PathVariable Integer id) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        tareaRepository.delete(tarea);
        return tarea;
    }     
  
}