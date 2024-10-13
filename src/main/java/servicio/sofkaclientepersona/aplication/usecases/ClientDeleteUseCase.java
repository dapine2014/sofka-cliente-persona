package servicio.sofkaclientepersona.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.ports.inbound.IDeleteClient;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;

@Component
public class ClientDeleteUseCase implements IDeleteClient {

    private final IClientCommandService clientService;

    @Autowired
    public ClientDeleteUseCase(IClientCommandService clientService) {
        this.clientService = clientService;
    }

    @Override
    public void deletePersona(Long id) {
     clientService.eliminarCliente(id);
    }
}
