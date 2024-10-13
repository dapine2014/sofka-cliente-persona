package servicio.sofkaclientepersona.infrastructure.adapters.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.outbound.IReadClient;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IReadClient readClient;

    public ClienteController(IReadClient readClient) {
        this.readClient = readClient;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getClientById(@PathVariable Long id) {
       try {
           ClienteDto clienteDto = readClient.findById(id);
           return ResponseEntity.ok(clienteDto);
       }catch (IllegalArgumentException e) {
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado en la consulta .");
       }
    }


    @GetMapping
    public ResponseEntity<Object> getAllClients() {
        try {
            List<ClienteDto> clientes = readClient.findAll();
            return ResponseEntity.ok(clientes);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ocurrió un error inesperado en la consulta.");
        }
    }
}
