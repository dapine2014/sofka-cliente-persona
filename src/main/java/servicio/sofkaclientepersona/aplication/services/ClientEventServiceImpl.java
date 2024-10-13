package servicio.sofkaclientepersona.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.domain.entities.Cliente;
import servicio.sofkaclientepersona.domain.repositories.ClienteEntityRepository;
import servicio.sofkaclientepersona.domain.services.IClientEventService;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientEventServiceImpl implements IClientEventService {

    private final ClienteEntityRepository repository;
    private final ModelMapper mapper;

    public ClientEventServiceImpl(ClienteEntityRepository entityRepository) {
        this.repository = entityRepository;
        this.mapper = new ModelMapper();;
    }

    @Override
    public List<ClienteDto> obtenerTodosLosClientes() {

        List<Cliente> clientes = repository.findAll();
        return clientes.stream()
                .map(cliente -> mapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDto obtenerClientePorId(Long id) {
        return mapper.map(repository.findById(id).orElse(null), ClienteDto.class);
    }
}
