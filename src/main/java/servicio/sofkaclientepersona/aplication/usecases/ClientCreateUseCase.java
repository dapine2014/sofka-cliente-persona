package servicio.sofkaclientepersona.aplication.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.ClienteDto;
import servicio.sofkaclientepersona.aplication.dto.QueryDto;
import servicio.sofkaclientepersona.aplication.dto.TopicDto;
import servicio.sofkaclientepersona.aplication.ports.inbound.ICreateClient;
import servicio.sofkaclientepersona.domain.services.IClientCommandService;
import servicio.sofkaclientepersona.infrastructure.adapters.outbound.service.IKafkaSendMessage;

import java.util.ArrayList;
import java.util.List;

import static servicio.sofkaclientepersona.utils.JsonUtil.toJson;

@Component
public class ClientCreateUseCase implements ICreateClient {

    private final IClientCommandService clientService;

    private final IKafkaSendMessage cuenta;

    @Autowired
    public ClientCreateUseCase(IClientCommandService clientCommandService, IKafkaSendMessage cuenta) {
        this.clientService = clientCommandService;
        this.cuenta = cuenta;
    }

    @Override
    public ClienteDto create(ClienteDto clients) {
        ClienteDto clienteDto = clientService.crearCliente(clients);
        List<QueryDto> queryDto = new ArrayList<>();
        queryDto.add(new QueryDto("CREANDO",clienteDto.getId().toString()));
        TopicDto query = TopicDto.builder()
                .uuIdFrom(clienteDto.getId().toString())
                .from("PERSONA_TOPIC")
                .to("CLIENTES_TOPIC")
                .uuIdTo(null)
                .query(queryDto)
                .response(null)
                .build();

        cuenta.sendMessage(query.getTo(), query.getUuIdFrom(),toJson(query));

        return clienteDto;
    }
}
