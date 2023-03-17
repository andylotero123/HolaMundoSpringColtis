
package com.cultos.demo.dao;

import com.cultos.demo.domain.Persona;
import org.springframework.data.repository.CrudRepository;

//extiende de Crud repository para hacer un crud
public interface PersonaDao extends CrudRepository<Persona, Long>{
    
    
}
