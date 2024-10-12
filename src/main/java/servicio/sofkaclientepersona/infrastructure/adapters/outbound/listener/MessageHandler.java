package servicio.sofkaclientepersona.infrastructure.adapters.outbound.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import servicio.sofkaclientepersona.aplication.dto.MessageResponceDto;
import servicio.sofkaclientepersona.aplication.dto.TopicDto;
import servicio.sofkaclientepersona.infrastructure.adapters.inbound.service.KafkaMessageObserver;
import java.util.ArrayList;
import java.util.List;

import static servicio.sofkaclientepersona.utils.JsonUtil.fromJson;

@Slf4j
@Service
public class MessageHandler {
    private final List<KafkaMessageObserver> observers = new ArrayList<>();

    public void addObserver(KafkaMessageObserver observer) {
        this.observers.add(observer);
    }

    public void notify(String message) {
        for (KafkaMessageObserver observer : observers) {
            MessageResponceDto messageDto = fromJson(message, MessageResponceDto.class);
            observer.onMessageReceived(messageDto);
        }
    }

    public void processMessage(String message) {
        logReceivedMessage(message);
        TopicDto topicPojo = fromJson(message, TopicDto.class);
        if (topicPojo.getUuIdTo() == null) {
            createAndSendResponseMessage(topicPojo);
        } else {
            notify(message);
        }

    }

    public void logReceivedMessage(String message){
        log.info("Message received: {}", message);
    }

    private void createAndSendResponseMessage(TopicDto data){

    }
}
