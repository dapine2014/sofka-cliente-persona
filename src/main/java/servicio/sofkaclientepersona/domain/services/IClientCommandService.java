package servicio.sofkaclientepersona.domain.services;

import servicio.sofkaclientepersona.aplication.dto.ClienteDto;


public interface IClientCommandService {
    ClienteDto crearCliente(ClienteDto cliente);
    ClienteDto actualizarCliente(Long id, ClienteDto clienteDto);
    public void eliminarCliente(Long id);

}
