package com.example.shop.repository;


import com.example.shop.entity.RandomDiscount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RandomDiscountRepository extends JpaRepository<RandomDiscount, Long> {

    @Query(value = "select * " +
            "from random_discount d " +
            "order by d.created_at desc " +
            "limit 1",
            nativeQuery = true)
    Optional<RandomDiscount> findActualDiscount();

}
