package ar.com.smartsol.prueba01.spring_boot.repositories;

import org.springframework.data.repository.CrudRepository;
import ar.com.smartsol.prueba01.spring_boot.models.Persona;

//                                                       <Model , Tipo de dato de la primary key>
public interface PersonaRepository extends CrudRepository<Persona, Integer>{

}