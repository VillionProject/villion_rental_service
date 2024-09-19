package org.example.villion_rental_service.controller;

import lombok.RequiredArgsConstructor;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.repository.RentalRepository;
import org.example.villion_rental_service.service.RentalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rental")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService rentalService;

    @GetMapping("/getAllRentalsByUserID/{userId}")
    public List<RentalEntity> getAllRentalsByUserId(@PathVariable("userId") Long userId) {
        return rentalService.getAllRentalsByUserId(userId);
    }
}
