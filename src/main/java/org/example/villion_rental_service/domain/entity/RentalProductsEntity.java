package org.example.villion_rental_service.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "rentalProducts")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class rentalProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalProductsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rental_id")
    private RentalEntity rental;

    private Long productId;
    private String productName;
    private Long quantity;
    private Long price;
}
