package org.example.villion_rental_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.villion_rental_service.domain.dto.OrderDto;
import org.example.villion_rental_service.domain.eunm.*;
import org.hibernate.query.Order;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "rentals")
public class RentalEntity {
//    #제품
//    private Long productId;
//
//    //    #사용자
//    //    private Long userId;
//    private Long ownerUserId; // 책주인(대여받는 사람)(defalt)
//    private Long renterUserId; // 대여하는 사람
//
//
//    //    #대여
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long rentalId; // 대여계약 체결 시 생성
//
//    private String bookName;
//    @Enumerated(EnumType.STRING)
//    private Category category; // enum
//
//    private LocalDate rentalStartDate; // 대여 시작일
//    private LocalDate rentalEndDate;   // 대여 종료일
//    private Long totalRentalQuantity;
//    @Enumerated(EnumType.STRING)
//    private RentalStatus rentalStatus; // 대여 상태(대여가능/채팅중/대여완료)
////    private ProductStatus productStatus; // 상품 상태
////    private String productDescription; // 상품 설명
//    private LocalDateTime orderedAt; // 주문일
////    private LocalDateTime updatedAt; // 게시글 수정일
//    private Long totalRentalPrice;
//    @Enumerated(EnumType.STRING)
//    private RentalMethod rentalMethod; // enum 대여 방법
//    private String rentalLocation;
//    private Boolean rentable;
//    private Boolean purchasable;



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
    private String rentalLocation;
    private LocalDateTime orderedAt; // 주문일

}
