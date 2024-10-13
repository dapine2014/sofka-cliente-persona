package servicio.sofkaclientepersona.aplication.dto;

import lombok.Value;
import servicio.sofkaclientepersona.domain.entities.Persona;

import java.io.Serializable;

/**
 * DTO for {@link Persona}
 */
@Value
public class PersonaEntityDto implements Serializable {
    Long id;
    String nombre;
    String genero;
    Integer edad;
    String identificacion;
    String direccion;
    String telefono;
}