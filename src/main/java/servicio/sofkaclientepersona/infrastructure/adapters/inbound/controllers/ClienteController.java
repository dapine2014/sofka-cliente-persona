package servicio.sofkaclientepersona.infrastructure.adapters.inbound.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.ports.inbound.ICreateClient;
import servicio.sofkaclientepersona.aplication.ports.inbound.IDeleteClient;
import servicio.sofkaclientepersona.aplication.ports.inbound.IUpdateClient;
import servicio.sofkaclientepersona.aplication.ports.outbound.IReadClient;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final IReadClient readClient;
    private final ICreateClient createClient;
    private final IUpdateClient updateClient;
    private final IDeleteClient deleteClient;

    public ClienteController(IReadClient readClient, ICreateClient createClient, IUpdateClient updateClient, IDeleteClient deleteClient) {
        this.readClient = readClient;
        this.createClient = createClient;
        this.updateClient = updateClient;
        this.deleteClient = deleteClient;
    }


    @PostMapping()
    public ResponseEntity<Object> createCliente(@RequestBody ClienteDto clienteDto) {
       try {
           ClienteDto cliente = createClient.create(clienteDto);
           return ResponseEntity.status(HttpStatus.CREATED).body(cliente);
       } catch (IllegalArgumentException e){
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                   .body("Ocurrió un error inesperado al crear ");
       }
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

    @PutMapping("/{id}")
   public  ResponseEntity<Object> updateClient(@PathVariable Long id,@RequestBody ClienteDto clienteDto) {
     try {
         ClienteDto client =  updateClient.update(id, clienteDto);
         return ResponseEntity.ok(client);
     }catch (IllegalArgumentException e){
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
     } catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("ocurrio un error inesperado al modificar ");
     }
   }

   @DeleteMapping("/{id}")
   public ResponseEntity<Void> deleteClient(@PathVariable Long id) {
       deleteClient.deletePersona(id);
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);
   }

}
