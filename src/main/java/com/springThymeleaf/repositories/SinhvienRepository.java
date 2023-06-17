package com.springThymeleaf.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.springThymeleaf.models.Sinhvien;

public interface SinhvienRepository extends JpaRepository<Sinhvien, Integer>, JpaSpecificationExecutor<Sinhvien> {

}