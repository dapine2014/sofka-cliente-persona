package servicio.sofkaclientepersona.infrastructure.adapters.inbound.components;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.aplication.dto.MessageResponceDto;
import servicio.sofkaclientepersona.infrastructure.adapters.inbound.service.KafkaMessageObserver;

@Slf4j
@Component
public class KafkaMessageReception implements KafkaMessageObserver {

    @Override
    public void onMessageReceived(MessageResponceDto message) {

    }
}
