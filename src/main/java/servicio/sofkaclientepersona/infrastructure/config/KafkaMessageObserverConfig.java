package servicio.sofkaclientepersona.infrastructure.config;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import servicio.sofkaclientepersona.infrastructure.adapters.inbound.components.KafkaMessageReception;
import servicio.sofkaclientepersona.infrastructure.adapters.outbound.listener.MessageHandler;

@Configuration
public class KafkaMessageObserverConfig {

    @Autowired
    private MessageHandler HandlerListener;

    @Autowired
    public KafkaMessageReception messageReception;

    @PostConstruct
    public void init() {
        HandlerListener.addObserver(messageReception);
    }
}
