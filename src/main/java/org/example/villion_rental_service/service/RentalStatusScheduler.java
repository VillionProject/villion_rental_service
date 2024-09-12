package org.example.villion_rental_service.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.domain.entity.RentalProductsEntity;
import org.example.villion_rental_service.domain.eunm.RentalStatus;
import org.example.villion_rental_service.kafka.UpdateRentalStatusProducer;
import org.example.villion_rental_service.repository.RentalRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalStatusScheduler {

    private final RentalRepository rentalRepository;
    private final UpdateRentalStatusProducer updateRentalStatusProducer;

    @Scheduled(cron = "0 0 0 * * ?") // (cron = 초 분 시간 일 월 요일)
    @Transactional
    // (cron = 초 분 시간 일 월 요일)
    public void updateRentalStatus() {
        LocalDate now = LocalDate.now();
        List<RentalEntity> expiredRentals = rentalRepository.findAllByRentalEndDateBefore(now); // 현재시간보다 이전인 항목 찾기

            for (RentalEntity rental : expiredRentals) {
                Long productId = rental.getProductId(); // 대여된 제품 ID를 가져옴

                rental.getRentalProducts().stream()
                        .map(RentalProductsEntity::getQuantity)
                        .forEach(quantity -> {
                            // 제품 상태 업데이트 메시지를 발행, productId와 quantity를 함께 보냄
                            updateRentalStatusProducer.sendUpdateStatusMessage(productId, RentalStatus.AVAILABLE, quantity);

                            System.out.println("ProductId: " + productId + ", Quantity: " + quantity);
                        });
            }

//            UpdateRentalStatusProducer(TopicConfig.updateRentalStatus, RentalStatus.AVAILABLE);

        System.out.println("Updated rental statuses for expired rentals.");
    }
}

