package org.example.villion_rental_service.kafka;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.villion_rental_service.domain.dto.AddRentedDeliveryOrderDto;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.domain.entity.RentalProductsEntity;
import org.example.villion_rental_service.repository.RentalProductRepository;
import org.example.villion_rental_service.repository.RentalRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DeliveryOrderConsumer {
    private final RentalRepository rentalRepository;
    private final RentalProductRepository rentalProductRepository;

    @KafkaListener(topics = TopicConfig.addRentedDeliveryOrder)
    public void addDeliveryOrderResult(AddRentedDeliveryOrderDto addRentedDeliveryOrderDto) {

        System.out.println("Received message: " + addRentedDeliveryOrderDto);
        try {
            // 빈 RentalEntity 객체 생성 및 저장
            RentalEntity rental = RentalEntity.builder().build();
            // rentalId 생성
            RentalEntity saveRental = rentalRepository.save(rental);

            // DTO 객체를 RentalEntity로 매핑
            ModelMapper mapper = new ModelMapper();
            mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
            RentalEntity rentalEntity = mapper.map(addRentedDeliveryOrderDto, RentalEntity.class);

            // 매핑된 RentalEntity 객체에 저장된 rentalId 및 OrderedAt 주문일 설정
            rentalEntity.setRentalId(saveRental.getRentalId());
            rentalEntity.setOrderedAt(LocalDateTime.now());

            // RentalProductsEntity 목록 생성 및 각 제품 저장
            List<RentalProductsEntity> productList = new ArrayList<>();

            for(RentalProductsEntity rentalProducts : rentalEntity.getRentalProducts()) {
                // rentalProducts 객체의 rental 필드를 설정
//                rentalProducts.setRental(rentalEntity);

                // 리스트에 rentalProducts 객체를 추가
                productList.add(rentalProducts);
            }
            rentalProductRepository.saveAll(productList);
            rentalRepository.save(rentalEntity);

        } catch (Exception e) {
            System.err.println("Error processing Kafka message: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
