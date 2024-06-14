package org.example.villion_rental_service.domain.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.example.villion_rental_service.domain.eunm.RentalMethod;
import org.example.villion_rental_service.domain.eunm.RentalStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "rentals")
public class RentalEntity {
//    #제품
    private Long productId;
//    private String productName;
//    private ProductGroup productGroup; // eunm : BOOK/OTHERS


//    #사용자
//    private Long userId;
    private Long ownerUserId; // 책주인(대여받는 사람)(defalt)
    private Long renterUserId; // 대여하는 사람


//    #대여
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalId; // 대여계약 체결 시 생성
    private LocalDate rentalStartDate; // 대여 시작일
    private LocalDate rentalEndDate;   // 대여 종료일
    @Enumerated(EnumType.STRING)
    private RentalStatus rentalStatus; // 대여 상태(대여가능/채팅중/대여완료)
//    private ProductStatus productStatus; // 상품 상태
//    private String productDescription; // 상품 설명
    private LocalDateTime orderedAt; // 주문일
//    private LocalDateTime updatedAt; // 게시글 수정일
    private Long totalRentalPrice;
    private RentalMethod rentalMethod; // enum 대여 방법
    private String rentalLocation;
//    private Boolean rentable;
//    private Boolean purchasable;
}
