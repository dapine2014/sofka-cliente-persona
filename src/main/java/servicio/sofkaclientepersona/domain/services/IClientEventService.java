package servicio.sofkaclientepersona.domain.services;

import servicio.sofkaclientepersona.aplication.dto.ClienteDto;

import java.util.List;

public interface IClientEventService {
    List<ClienteDto> obtenerTodosLosClientes();
    ClienteDto obtenerClientePorId(Long id);
}
