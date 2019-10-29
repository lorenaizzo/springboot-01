package ar.com.smartsol.prueba01.spring_boot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import ar.com.smartsol.prueba01.spring_boot.models.Tarea;
import ar.com.smartsol.prueba01.spring_boot.repositories.TareaRepository;

@RestController
@RequestMapping("tareas")
public class PrimerController {

    @Autowired
    private TareaRepository tareaRepository;

    @GetMapping("/")
    public Iterable<Tarea> listar() {
        return this.tareaRepository.findAll();
    }

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

    @PutMapping("/{id}")
    public Tarea actualizar(@PathVariable Integer id, @RequestBody Tarea peticion) {
        Tarea tarea = tareaRepository.findById(id).orElse(null);
        if (tarea==null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarea no encontrada");
        }
        tarea.setNombre(peticion.getNombre());
        tarea.setTerminada(peticion.getTerminada());
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