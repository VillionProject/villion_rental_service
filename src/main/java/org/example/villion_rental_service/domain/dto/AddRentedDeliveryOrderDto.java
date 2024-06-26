package org.example.villion_rental_service.domain.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.villion_rental_service.domain.entity.ProductEntity;
import org.example.villion_rental_service.domain.eunm.*;

import java.time.LocalDate;
import java.util.List;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class AddRentedDeliveryOrderDto {
    private Long Id;

    private Long ownerUserId; // 책주인(대여받는 사람)(defalt)
    private Long renterUserId; // 대여하는 사람

    // 대여 정보
    private Long productId;
    private LocalDate rentalStartDate; //  대여 시작일
    private LocalDate rentalEndDate; // 대여 종료일
//    private Long totalRentalQuantity;
 // 주문 내역은 화면에서 받아서 보여주기
//    private Long totalRentalPrice;
//    private List<OrderDto> orderList;

    // 결제 내역 정보
    private PaymentMethod paymentMethod;

    // 도서 정보
    private String bookName;
    @Enumerated(EnumType.STRING)
    private Category category; // enum
    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus; // enum
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus; // 대여 상태
    private Long rentalQuantity;
    //    private LocalDate rentalPeriod; // 대여 가능 기간
    private Long rentalPrice;
    @Enumerated(EnumType.STRING)
    private RentalMethod rentalMethod; // enum
//    private boolean popularity; // 인기제품이다 아니다.
    private String rentalLocation;
}
