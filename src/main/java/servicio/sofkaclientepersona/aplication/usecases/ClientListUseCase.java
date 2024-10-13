package servicio.sofkaclientepersona.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.outbound.IReadClient;
import servicio.sofkaclientepersona.domain.services.IClientEventService;

import java.util.List;

@Component
public class ClientListUseCase implements IReadClient {

    private final IClientEventService clientEventService;

    @Autowired
    public ClientListUseCase(IClientEventService clientEventService) {
        this.clientEventService = clientEventService;
    }

    @Override
    public ClienteDto findById(Long id) {

        return clientEventService.obtenerClientePorId(id);
    }

    @Override
    public List<ClienteDto> findAll() {
        return clientEventService.obtenerTodosLosClientes();
    }
}
