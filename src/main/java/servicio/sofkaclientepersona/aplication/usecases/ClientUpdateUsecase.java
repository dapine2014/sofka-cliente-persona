package servicio.sofkaclientepersona.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.inbound.IUpdateClient;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;

@Component
public class ClientUpdateUsecase implements IUpdateClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientUpdateUsecase(IClientCommandService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ClienteDto update(Long id, ClienteDto clienteDto) {
        return clientService.actualizarCliente(id, clienteDto);
    }
}
