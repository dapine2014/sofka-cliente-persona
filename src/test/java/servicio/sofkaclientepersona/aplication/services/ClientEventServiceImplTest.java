package servicio.sofkaclientepersona.aplication.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.domain.entities.Cliente;
import servicio.sofkaclientepersona.domain.repositories.ClienteEntityRepository;
import servicio.sofkaclientepersona.utils.Validate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ClientEventServiceImplTest {

    @Mock
    private ClienteEntityRepository repository;

    @Mock
    private Validate validate;

    @InjectMocks
    private ClientEventServiceImpl service;
    private ModelMapper mapper = new ModelMapper();
    private List<Cliente> clientes;


    @BeforeEach
    void setUp() {
        // Inicializar la lista de clientes
        clientes = Arrays.asList(new Cliente());
    }


    @Test
    void obtenerTodosLosClientes() {
        when(repository.findAll()).thenReturn(clientes);

        // Actuar
        List<ClienteDto> resultado = service.obtenerTodosLosClientes();

        // Verificar
        assertEquals(clientes.size(), resultado.size());
        verify(repository, times(1)).findAll();
        verify(validate, times(1)).ValidateData(Collections.singletonList(any()));
    }

    @Test
    void obtenerClientePorId() {
        // Preparar
        Cliente cliente = clientes.get(0);
        when(repository.findById(any())).thenReturn(Optional.of(cliente));

        // Actuar
        ClienteDto resultado = service.obtenerClientePorId(1L);

        // Verificar
        assertEquals(mapper.map(cliente, ClienteDto.class), resultado);
        verify(repository, times(1)).findById(any());
    }
}