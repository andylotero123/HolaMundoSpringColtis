
package com.cultos.demo.servicio;

import com.cultos.demo.domain.Persona;
import java.util.List;

//interface para realizar el proceso del CRUD
public interface PersonaService {

    //metodos CRUD
    public List<Persona> listarPersonas();
    public void guardarPersona(Persona persona);
    public void eliminarPersona(Persona persona);
    public Persona encontrarPersona(Persona persona);
}
