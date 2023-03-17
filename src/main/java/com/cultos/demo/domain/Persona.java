
package com.cultos.demo.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data; //lombo: para manipular informacion de manera mas ccomoda

@Data //esta anotacion creo el contructor y los metodos accesores
@Entity
@Table(name = "persona") //para indicarle bien el nombre de la Tabla de la base de Datos
public class Persona implements Serializable{
    
    private static final long serialVersionUID = 1L; // para el ID sea mandado correctamente a la base de datos, desde aqui Long y labase de datos recibe un Long

    @Id //para identificar el Id, llave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY)//se usa para identificar el ID
    private Long idPersona; //este id tiene que ir debajo de las dos anteriores anotaciones,
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
}
