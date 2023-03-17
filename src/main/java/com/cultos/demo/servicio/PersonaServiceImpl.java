
package com.cultos.demo.servicio;

import com.cultos.demo.dao.PersonaDao;
import com.cultos.demo.domain.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service //Le indico a springboot que esta es la capa de sevicios 
public class PersonaServiceImpl implements  PersonaService{

    @Autowired //anotacion para inyectar los datos de las consultas provenientes de PersonaDao
    private PersonaDao PersonaDao; //para hacer una inyeccion de persona
    
    @Override
    @Transactional(readOnly = true)//esto es solo una consulta de usuario, solo devolver informacion para leer informacion
    public List<Persona> listarPersonas() {
        return (List<Persona>) PersonaDao.findAll();
    }

    @Override
    @Transactional //se envia una persona
    public void guardarPersona(Persona persona) {
        PersonaDao.save(persona);
    }

    @Override
    @Transactional
    public void eliminarPersona(Persona persona) {
        PersonaDao.delete(persona);
    }

    @Override
    @Transactional(readOnly = true)
    public Persona encontrarPersona(Persona persona) {
        return PersonaDao.findById(persona.getIdPersona()).orElse(null);
    }
}
