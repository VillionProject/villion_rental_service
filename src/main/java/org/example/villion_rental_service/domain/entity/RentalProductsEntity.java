package org.example.villion_rental_service.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class RentalProductsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentalProductsId;

//    @ManyToOne
//    @JoinColumn(name = "rentalId")
//    @JsonIgnore
//    private RentalEntity rental;

    private Long productId;
    private String productName;
    private Long quantity;
    private Long price;
}
