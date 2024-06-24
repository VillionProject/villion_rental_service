package org.example.villion_rental_service.domain.dto;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
public class OrderDto {
    private Long productId;
    private Long quantity;
    private Long price;
}
