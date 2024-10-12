package servicio.sofkaclientepersona.infrastructure.adapters.outbound.service;

public interface IKafkaSendMessage {
    String sendMessage(String topic, String key, String obj);
}
