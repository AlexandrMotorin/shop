package com.example.shop.repository;

import com.example.shop.entity.Deal;
import com.example.shop.models.DealIndex;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DealRepository extends JpaRepository<Deal, Long> {

    @Query(value = "select d.deal_date as date, d.check_number as checkNumber " +
            "from deal d " +
            "order by d.deal_date desc " +
            "limit 1",
            nativeQuery = true)
    DealIndex findLastDealIndex();

}
