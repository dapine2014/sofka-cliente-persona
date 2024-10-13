package servicio.sofkaclientepersona.aplication.ports.outbound;

import servicio.sofkaclientepersona.aplication.dto.ClienteDto;

import java.util.List;

public interface IReadClient {
    ClienteDto findById(Long id);
    List<ClienteDto> findAll();
}
