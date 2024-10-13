package servicio.sofkaclientepersona.aplication.dto;

import lombok.Data;
import servicio.sofkaclientepersona.domain.entities.Cliente;

import java.io.Serializable;

/**
 * DTO for {@link Cliente}
 */
@Data
public class ClienteDto implements Serializable {
    private   Long id;
    private   String nombre;
    private   String genero;
    private   Integer edad;
    private   String identificacion;
    private   String direccion;
    private   String telefono;
    private   String clienteId;
    private   String contrasena;
    private   Boolean estado;
}