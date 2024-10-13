package servicio.sofkaclientepersona.aplication.ports.inbound;

import servicio.sofkaclientepersona.domain.entities.Persona;

public interface IDeleteClient {
    void deletePersona(Long id);
}
