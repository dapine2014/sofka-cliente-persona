package servicio.sofkaclientepersona.aplication.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.domain.entities.Cliente;
import servicio.sofkaclientepersona.domain.repositories.ClienteEntityRepository;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;

@Service
public class ClientCommandServiceImpl implements IClientCommandService {

    private final ClienteEntityRepository entityRepository;
    private final ModelMapper mapper;

    @Autowired
    public ClientCommandServiceImpl(ClienteEntityRepository entityRepository) {
        this.entityRepository = entityRepository;
        this.mapper = new ModelMapper();
    }

    @Override
    public ClienteDto crearCliente(ClienteDto clientDto) {

        Cliente cliente = entityRepository.save( mapper.map(clientDto, Cliente.class));
        clientDto.setClienteId(cliente.getClienteId());

        return clientDto;
    }

    @Override
    public ClienteDto actualizarCliente(Long id, ClienteDto clienteDto) {
        return null;
    }

    @Override
    public void eliminarCliente(Long id) {
     entityRepository.deleteById(id);
    }
}
