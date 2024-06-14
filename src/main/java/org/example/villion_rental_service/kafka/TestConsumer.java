package org.example.villion_rental_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.villion_rental_service.domain.dto.AddRentedDeliveryOrderDto2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TestConsumer {
    @KafkaListener(topics = TopicConfig.testTopic)
    public void addDeliveryOrderResult(AddRentedDeliveryOrderDto2 addRentedDeliveryOrderDto2) {

        System.out.println(addRentedDeliveryOrderDto2);
    }
}
