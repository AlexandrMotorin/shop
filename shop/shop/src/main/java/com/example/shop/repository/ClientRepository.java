package com.example.shop.repository;

import com.example.shop.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long>, ClientStatisticRepository {
}

