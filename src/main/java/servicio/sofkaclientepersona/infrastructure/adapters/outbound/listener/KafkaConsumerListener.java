package servicio.sofkaclientepersona.infrastructure.adapters.outbound.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerListener {
    private static final String TOPIC_NAME = "CLIENT_TOPIC";
    private static final String GROUP_ID = "notification-service";
    private final MessageHandler messageHandler;

    @Autowired
    public KafkaConsumerListener(MessageHandler messageHandler) {
        this.messageHandler = messageHandler;
    }

    @KafkaListener(topics = TOPIC_NAME, groupId = GROUP_ID)
    public void consumeMessage(String message) {
        messageHandler.processMessage(message);
    }
}
