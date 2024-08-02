package org.example.villion_rental_service.repository;

import org.example.villion_rental_service.domain.entity.RentalEntity;
import org.example.villion_rental_service.domain.entity.RentalProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalProductRepository extends JpaRepository<RentalProductsEntity, Long> {
}
