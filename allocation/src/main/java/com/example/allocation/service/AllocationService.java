package com.example.allocation.service;

import com.example.allocation.model.Allocation;

import java.util.List;

public interface AllocationService {
    Allocation saveAllocation(Allocation allocation);
    List<Allocation> getAllocation(Long employee_id);
}
