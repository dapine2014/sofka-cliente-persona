package servicio.sofkaclientepersona.aplication.ports.inbound;

import servicio.sofkaclientepersona.aplication.dto.ClienteDto;

public interface IUpdateClient {
    ClienteDto update(Long id,ClienteDto clienteDto);
}
