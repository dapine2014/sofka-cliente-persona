package servicio.sofkaclientepersona.infrastructure.adapters.inbound.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import servicio.sofkaclientepersona.infrastructure.adapters.outbound.service.IKafkaSendMessage;
import servicio.sofkaclientepersona.utils.KafkaMessageException;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaMessageImp implements IKafkaSendMessage {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    public KafkaMessageImp(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    @Override
    public String sendMessage(String topic, String key, String obj) {
        String keyMessage;
        try {
            keyMessage = kafkaTemplate.send(topic, key, obj).get().getProducerRecord().key();
        } catch (InterruptedException | ExecutionException e) {
            throw new KafkaMessageException("Failed to send Kafka message", e);
        }
        return keyMessage;
    }


}
