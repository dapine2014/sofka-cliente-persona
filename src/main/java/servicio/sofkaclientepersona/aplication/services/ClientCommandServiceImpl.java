package servicio.sofkaclientepersona.aplication.services;

import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.outbound.IReadClient;
import servicio.sofkaclientepersona.domain.entities.Cliente;
import servicio.sofkaclientepersona.domain.repositories.ClienteEntityRepository;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;
import servicio.sofkaclientepersona.utils.Validate;

import java.util.Optional;

@Service
public class ClientCommandServiceImpl implements IClientCommandService {

    private final IReadClient readClient;
    private final ClienteEntityRepository entityRepository;
    private final ModelMapper mapper;
    private final Validate validate;

    @Autowired
    public ClientCommandServiceImpl(IReadClient readClient, ClienteEntityRepository entityRepository, Validate validate) {
        this.readClient = readClient;
        this.entityRepository = entityRepository;
        this.validate = validate;
        this.mapper = new ModelMapper();
    }

    @Override
    public ClienteDto crearCliente(ClienteDto clientDto) {

        validate.ValidateData(clientDto);
        Cliente cliente = entityRepository.save( mapper.map(clientDto, Cliente.class));
        clientDto.setClienteId(cliente.getClienteId());

        return clientDto;
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteDto clienteDto) {
        validate.ValidateData(id);
        validate.ValidateData(clienteDto);
        Optional<Cliente> optionalCliente = entityRepository.findByClienteId(clienteDto.getClienteId());
        if (optionalCliente.isPresent()) {
            Cliente cliente = optionalCliente.get();
            cliente.setNombre(clienteDto.getNombre());
            cliente.setGenero(clienteDto.getGenero());
            cliente.setEdad(clienteDto.getEdad());
            cliente.setIdentificacion(clienteDto.getIdentificacion());
            cliente.setDireccion(clienteDto.getDireccion());
            cliente.setTelefono(clienteDto.getTelefono());
            cliente.setContrasena(clienteDto.getContrasena());
            cliente.setEstado(clienteDto.getEstado());
            entityRepository.save(cliente);

            return mapper.map(cliente, ClienteDto.class);
        } else {
            throw new EntityNotFoundException("Cliente not found with id: " + clienteDto.getClienteId());
        }
    }

    @Override
    public void eliminarCliente(Long id) {
        validate.ValidateData(id);
        ClienteDto client = readClient.findById(id);
        entityRepository.delete(mapper.map(client, Cliente.class));
    }
}
