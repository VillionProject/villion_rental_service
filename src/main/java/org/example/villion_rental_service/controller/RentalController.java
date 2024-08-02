package org.example.villion_rental_service.controller;

import lombok.RequiredArgsConstructor;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.repository.RentalRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {

    private final RentalRepository rentalRepository;

    @GetMapping
    public RentalEntity test() {
        return rentalRepository.findById(1L).orElseThrow();
    }
}
