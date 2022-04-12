package ulas.kafkaproducer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ulas.kafkaproducer.config.Producer;
import ulas.kafkaproducer.entity.FoodOrder;

@Service
@RequiredArgsConstructor
public class FoodOrderService {

    private final Producer producer;

    public String createFoodOrder(FoodOrder foodOrder) throws JsonProcessingException {
        return producer.sendMessage(foodOrder);
    }
}
