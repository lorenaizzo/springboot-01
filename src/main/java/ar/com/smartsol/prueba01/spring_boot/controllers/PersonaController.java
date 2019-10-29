package ar.com.smartsol.prueba01.spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ar.com.smartsol.prueba01.spring_boot.models.Persona;
import ar.com.smartsol.prueba01.spring_boot.repositories.PersonaRepository;

@RestController
@RequestMapping("personas")
public class PersonaController {

    @Autowired
    private PersonaRepository personaRepository;

    @GetMapping("/")
    public Iterable<Persona> listar() {
        return this.personaRepository.findAll();
    }

    @PostMapping("/")
    public  Persona agregar(@RequestBody Persona peticion) {
        personaRepository.save(peticion);
        return peticion;
    }

    @GetMapping("/{id}")
    public Persona obtener(@PathVariable Integer id) {
        Persona tarea = personaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
        }
        return tarea;
    }    

    @PutMapping("/{id}")
    public Persona actualizar(@PathVariable Integer id, @RequestBody Persona peticion) {
        Persona tarea = personaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
        }
        tarea.setNombre(peticion.getNombre());
        tarea.setApellido(peticion.getApellido());
        personaRepository.save(tarea);
        return tarea;
    } 

    @DeleteMapping("/{id}")
    public Persona borrar(@PathVariable Integer id) {
        Persona tarea = personaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Persona no encontrada");
        }
        personaRepository.delete(tarea);
        return tarea;
    }     
}