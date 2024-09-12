package org.example.villion_rental_service.repository;

import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface RentalRepository extends JpaRepository<RentalEntity, Long> {
    List<RentalEntity> findAllByRentalEndDateBefore(LocalDate localDate);
}
