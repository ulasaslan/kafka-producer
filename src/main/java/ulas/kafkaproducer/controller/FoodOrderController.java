package ulas.kafkaproducer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ulas.kafkaproducer.entity.FoodOrder;
import ulas.kafkaproducer.service.FoodOrderService;

@RestController
@RequestMapping("/order")
@RequiredArgsConstructor
public class FoodOrderController {
    private final FoodOrderService foodOrderService;

    @PostMapping
    public String createFoodOrder(@RequestBody FoodOrder foodOrder) throws JsonProcessingException {
        return foodOrderService.createFoodOrder(foodOrder);
    }
}
