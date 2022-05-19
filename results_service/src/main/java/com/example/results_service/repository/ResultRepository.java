package com.example.results_service.repository;

import com.example.results_service.entity.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultRepository extends JpaRepository<Result, Long> {
    @Query("SELECT r FROM Result r WHERE r.code = ?1 AND r.status = 0")
    Result findByCode(String code);
}
