package servicio.sofkaclientepersona.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.domain.entities.Cliente;
import servicio.sofkaclientepersona.domain.repositories.ClienteEntityRepository;
import servicio.sofkaclientepersona.domain.services.IClientEventService;
import servicio.sofkaclientepersona.utils.Validate;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientEventServiceImpl implements IClientEventService {

    private final ClienteEntityRepository repository;
    private final ModelMapper mapper;
    private final Validate validate;

    public ClientEventServiceImpl(ClienteEntityRepository entityRepository, Validate validate) {
        this.repository = entityRepository;
        this.validate = validate;
        this.mapper = new ModelMapper();;
    }

    @Override
    public List<ClienteDto> obtenerTodosLosClientes() {

        List<Cliente> clientes = repository.findAll();
        List<ClienteDto> clienteDtos = clientes.stream()
                .map(cliente -> mapper.map(cliente, ClienteDto.class))
                .collect(Collectors.toList());
        validate.ValidateData(clienteDtos);

        return clienteDtos;
    }

    @Override
    public ClienteDto obtenerClientePorId(Long id) {
        validate.ValidateData(id);
        return mapper.map(repository.findById(id).orElse(null), ClienteDto.class);
    }
}
