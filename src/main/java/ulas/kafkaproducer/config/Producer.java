package ulas.kafkaproducer.config;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import ulas.kafkaproducer.entity.FoodOrder;

@Component
@RequiredArgsConstructor
public class Producer {
    @Value("${topic.name}")
    private String orderTopic;

    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public String sendMessage(FoodOrder foodOrder) throws JsonProcessingException {
        String orderAsMessage = objectMapper.writeValueAsString(foodOrder);
        kafkaTemplate.send(orderTopic, orderAsMessage);
        return "message sent";
    }

}
