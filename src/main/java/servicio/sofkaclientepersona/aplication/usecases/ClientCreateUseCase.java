package servicio.sofkaclientepersona.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.inbound.ICreateClient;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;

@Component
public class ClientCreateUseCase implements ICreateClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientCreateUseCase(IClientCommandService clientCommandService) {
        this.clientService = clientCommandService;
    }

    @Override
    public ClienteDto create(ClienteDto clients) {
        return clientService.crearCliente(clients);
    }
}
