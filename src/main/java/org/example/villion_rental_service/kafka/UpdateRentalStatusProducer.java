package org.example.villion_rental_service.kafka;

import lombok.extern.slf4j.Slf4j;
import org.example.villion_rental_service.domain.eunm.RentalStatus;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UpdateRentalStatusProducer {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final String topic;

    public UpdateRentalStatusProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = TopicConfig.updateRentalStatus;
    }

    public void sendUpdateStatusMessage(Long productId, RentalStatus status, Long quantity) {
        // 메시지 포맷 설정
        String message = String.format("productId:%d,status:%s, quantity:%s", productId, status, quantity);

        // 주제에 메시지 전송
        kafkaTemplate.send(TopicConfig.updateRentalStatus, message);
    }

//    public void send(String topic, RentalStatus rentalStatus) {
//        kafkaTemplate.send(topic, rentalStatus);
//    }
}
