package ar.com.smartsol.prueba01.spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;
import ar.com.smartsol.prueba01.spring_boot.models.Tarea;

//                                                      <Model , Tipo de dato de la primary key>
public interface TareaRepository extends CrudRepository<Tarea, Integer>{

}