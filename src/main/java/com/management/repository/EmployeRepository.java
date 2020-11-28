package com.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.management.entities.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer>{

}
