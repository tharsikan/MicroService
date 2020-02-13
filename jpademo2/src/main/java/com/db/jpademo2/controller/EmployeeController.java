package com.db.jpademo2.controller;

import com.db.jpademo2.model.Employee;
import com.db.jpademo2.service.EmployeeService;
import com.db.pojo.Allocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value="/employee", method= RequestMethod.POST)
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }
    
    @RequestMapping(value="/employee/{employee_id}", method= RequestMethod.GET)
    public Employee saveEmployee(@PathVariable Long employee_id){
        return employeeService.getEmployee(employee_id);
    }
    
    @RequestMapping(value="/employee/{employee_id}/allocation", method= RequestMethod.POST)
    public Allocation saveAllocation(@PathVariable Long employee_id,@RequestBody Allocation allocation){
        return employeeService.saveAllocation(employee_id,allocation);
    }
    
    @RequestMapping(value="/employee/{employee_id}/allocation", method= RequestMethod.GET)
    public Allocation[] getAllocation(@PathVariable Long employee_id){
        return employeeService.getAllAllocation(employee_id);
    }

}
