package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {

}
