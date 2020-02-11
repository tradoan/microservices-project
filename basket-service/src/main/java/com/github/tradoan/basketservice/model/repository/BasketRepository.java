package com.github.tradoan.basketservice.model.repository;

import com.github.tradoan.basketservice.model.entity.Basket;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasketRepository extends CrudRepository<Basket, Long> {
    List<Basket> findByUserId(Long userId);
    Basket findByUserIdAndProductId(Long userId, Long productId);
}
