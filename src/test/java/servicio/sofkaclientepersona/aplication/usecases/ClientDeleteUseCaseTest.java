package servicio.sofkaclientepersona.aplication.usecases;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ClientDeleteUseCaseTest {

    @Mock
    private IClientCommandService clientService;

    private ClientDeleteUseCase clientDeleteUseCase;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        clientDeleteUseCase = new ClientDeleteUseCase(clientService);
    }

    @Test
    void deletePersona() {
        doNothing().when(clientService).eliminarCliente(any(Long.class));
        clientDeleteUseCase.deletePersona(1L);
        verify(clientService, times(1)).eliminarCliente(1L);
    }
}