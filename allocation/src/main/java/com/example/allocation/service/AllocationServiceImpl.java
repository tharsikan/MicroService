package com.example.allocation.service;

import com.example.allocation.model.Allocation;
import com.example.allocation.repository.AllocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AllocationServiceImpl implements AllocationService {

    @Autowired
    AllocationRepository allocationRepository;

    @Override
    public Allocation saveAllocation(Allocation allocation) {
        return allocationRepository.save(allocation);
    }

    @Override
    public List<Allocation> getAllocation(Long employee_id) {
        return  allocationRepository.findByEmployee_id(employee_id);
    }
}
