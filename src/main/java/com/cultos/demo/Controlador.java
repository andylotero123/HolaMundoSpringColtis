package com.cultos.demo;

import com.cultos.demo.domain.Persona;
import com.cultos.demo.servicio.PersonaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

//anotacion @RestController: para marcar la clase y sepa springBoot que es el controlador
//@RestController, solo para comunicacion con Http, y @Controller se comunica con el puerto 9090 y con la clase que maneja datos 
@Controller //anotacion
@Slf4j//para enviar informacion por consola
public class Controlador {

    //inyecto datos
    @Autowired
    private PersonaService personaService;

    @GetMapping("/")
    public String inicio(Model model) { //Model para que reconszca los metodos accesores de la clase Persona 

        //Variable mensaje para 
        /*   var mensaje = "mensaje con Thymeleaf";
        
        //creo un objeto
        var persona1 = new Persona(); //con var se cre directamente el objeto y luego el constructor
        
        persona1.setNombre("Anderson");
        persona1.setApellido("Lotero");
        persona1.setEmail("andy@gmail.com");
        persona1.setTelefono("12345");
        
        var persona2 = new Persona();
        
        persona2.setNombre("Andy");
        persona2.setApellido("Lotero");
        persona2.setEmail("anderson@gmail.com");
        persona2.setTelefono("12345");
        
        //guardo los objetos en un Arrat
        var listaPersonas = Arrays.asList(persona1, persona2);
        
        model.addAttribute("mensaje", mensaje); //estos sons atributos del objeto model, para luego mostrarlas
        model.addAttribute("listaPersonas", listaPersonas);
         */
        var listaPersonas = personaService.listarPersonas();
        model.addAttribute("listaPersonas", listaPersonas);
        return "index";
    }

    @GetMapping("/agregar")
    public String agregarPersona(Persona persona) {
        return "modificar";
    }

    @PostMapping("/guardar")
    public String guardar(Persona persona) {
        personaService.guardarPersona(persona);
        return "redirect:/";
    }

    @GetMapping("/editar/{idPersona}")
    public String editar(Persona persona, Model model) { //El model se usa para recargar los datos en algun lado o tabla o campos de texto
        persona = personaService.encontrarPersona(persona);
        model.addAttribute("persona", persona);
        return "modificar";
    }

    @GetMapping("/eliminar")
    public String eliminar(Persona persona) {
        personaService.eliminarPersona(persona);
        return "redirect:/";
    }

    //getMap para obtener obtener una solicitud http
   // metodo Post: para enviar
    //Metodo Get: para consultar, eliminar y editar
}
