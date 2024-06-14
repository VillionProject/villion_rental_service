package org.example.villion_rental_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.example.villion_rental_service.domain.dto.AddRentedDeliveryOrderDto;
import org.example.villion_rental_service.domain.dto.AddRentedDeliveryOrderDto2;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.repository.RentalRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryOrderConsumer {


    private final RentalRepository rentalRepository;

    @KafkaListener(topics = TopicConfig.addRentedDeliveryOrder)
    public void addDeliveryOrderResult(AddRentedDeliveryOrderDto addRentedDeliveryOrderDto) {
//        System.out.println(addRentedDeliveryOrderDto2);


        System.out.println("Received message: " + addRentedDeliveryOrderDto);
        try {
            System.out.println("Received message: " + addRentedDeliveryOrderDto);
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            RentalEntity rentalEntity = mapper.map(addRentedDeliveryOrderDto, RentalEntity.class);
            rentalEntity.setOrderedAt(LocalDateTime.now());
            rentalRepository.save(rentalEntity);
            System.out.println("Rental entity saved: " + rentalEntity);
        } catch (Exception e) {
            System.err.println("Error processing Kafka message: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
