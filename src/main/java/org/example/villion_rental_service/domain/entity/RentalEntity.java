package org.example.villion_rental_service.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.villion_rental_service.domain.dto.OrderDto;
import org.example.villion_rental_service.domain.eunm.*;
import org.hibernate.query.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "rentals")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentalEntity {
    //    #사용자
    private Long ownerUserId; // 책주인(대여받는 사람)(defalt)
    private Long renterUserId; // 대여하는 사람


    //    #대여
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId; // 대여계약 체결 시 생성

    //    #제품
    private Long productId;
    private LocalDate rentalStartDate; // 대여 시작일
    private LocalDate rentalEndDate;   // 대여 종료일
    private Long totalRentalQuantity;
    private Long totalRentalPrice;

    // 결제 내역 정보
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private Long usedPoints;
    private Long shippingCost;

    // 주문 정보
    private String userName;
    private Long phoneNumber;
    private String address;
    private String deliveryMemo;

    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus; // 대여 상태
    @Enumerated(EnumType.STRING)
    private RentalMethod rentalMethod; // enum
    private LocalDateTime orderedAt; // 주문일


    // 주문 목록
//    @OneToMany(mappedBy = "rental")
    @OneToMany
    @JoinColumn(name = "rentalproducts_id")
    @OrderColumn(name = "order_no")
    private List<RentalProductsEntity> rentalProducts;


//    @OneToMany()
//    private List<RentalProductsEntity> rentalProducts;

//    public void add(RentalProductsEntity rentalProductsEntity) {
//        rentalProductsEntity.setRental(this);
//        getRentalProducts().add(rentalProductsEntity);
//    }

}
