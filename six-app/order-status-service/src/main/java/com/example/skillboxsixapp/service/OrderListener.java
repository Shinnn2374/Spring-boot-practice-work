package com.example.skillboxsixapp.service;

import com.example.skillboxsixapp.model.OrderEvent;
import com.example.skillboxsixapp.model.OrderStatusEvent;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@Data
public class OrderListener
{
    @Autowired
    private KafkaTemplate<String, OrderStatusEvent> kafkaTemplate;

    @KafkaListener(topics = "order-topic", groupId = "order-group")
    public void listen(OrderEvent orderEvent) {
        // Создаем событие OrderStatusEvent
        OrderStatusEvent orderStatusEvent = new OrderStatusEvent();
        orderStatusEvent.setStatus("CREATED");
        orderStatusEvent.setDate(Instant.now());

        // Отправляем событие в топик order-status-topic
        kafkaTemplate.send("order-status-topic", orderStatusEvent);
    }
}
