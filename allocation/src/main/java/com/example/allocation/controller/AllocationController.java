package com.example.allocation.controller;

import com.example.allocation.model.Allocation;
import com.example.allocation.service.AllocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AllocationController {

    @Autowired
    AllocationService allocationService;

    @RequestMapping(value = "/{employee_id}/allocation",method = RequestMethod.POST)
    public Allocation saveAllocation(@RequestBody Allocation allocation, @PathVariable Long employee_id){
        allocation.setEmployee_id(employee_id);
        return  allocationService.saveAllocation(allocation);
    }

    @RequestMapping(value = "/{employee_id}/allocation",method = RequestMethod.GET)
    public List<Allocation> getAllocation(@PathVariable Long employee_id){
        return allocationService.getAllocation(employee_id);
    }
}
