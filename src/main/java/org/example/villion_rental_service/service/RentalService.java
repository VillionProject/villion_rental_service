package org.example.villion_rental_service.service;

import lombok.RequiredArgsConstructor;
import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;

    public List<RentalEntity> getAllRentalsByUserId(Long userId) {
        return rentalRepository.findAllByRenterUserId(userId);
    }

}
