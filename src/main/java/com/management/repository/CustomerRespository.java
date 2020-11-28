package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.entities.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Integer> {

}
