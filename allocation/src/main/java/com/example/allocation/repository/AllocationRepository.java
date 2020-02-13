package com.example.allocation.repository;

import com.example.allocation.model.Allocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AllocationRepository extends JpaRepository<Allocation,Long> {
    @Query("SELECT a FROM Allocation a WHERE a.employee_id = ?1")
    List<Allocation> findByEmployee_id(Long employee_id);
}
