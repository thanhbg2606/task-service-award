package com.example.results_service.repository;

import com.example.results_service.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
    Result findByCode(String code);
}
