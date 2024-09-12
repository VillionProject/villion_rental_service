package org.example.villion_rental_service.service;

import lombok.RequiredArgsConstructor;
import org.example.villion_rental_service.repository.RentalRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RentalService {
    private final RentalRepository rentalRepository;

//    public RentalDto addProduct(RentalDto rentalDto) {
//
//        ModelMapper mapper = new ModelMapper();
//        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
//        RentalEntity rentalEntity = mapper.map(rentalDto, RentalEntity.class);
//        rentalEntity.setRentalStatus(RentalStatus.AVAILABLE);
////        rentalEntity.setProductGroup(ProductGroup.BOOK); // TODO 이거 어떻게 구별하지?
//        rentalEntity.setOrderedAt(LocalDateTime.now());
//        rentalEntity.setOwnerUserId(rentalDto.getOwnerUserId());
//
//        rentalRepository.save(rentalEntity);
//
//
//        RentalDto returnVale = mapper.map(rentalEntity, RentalDto.class);
//
////        TODO
////         #1 만약 DB에 없는 상품을 등록하면 도서DB에 추가 되어야함(kafka 사용)
//        if (returnVale.getProductName() != null) {
//
//        }
//
////      TODO
////        #2 날짜 유효성
////        #3 시작일, 종료일 크기 비교
//
//
//        return returnVale;
//    }
//
//    public List<RentalEntity> getProductListByLocation(String location) {
//
//        List<RentalEntity> rentalEntity = rentalRepository.findAllByRentalLocation(location);
//
////        RentalEntity returnValue = new ModelMapper().map(rentalEntity, RentalEntity.class);
//
//
//        return rentalEntity;
//    }
}
