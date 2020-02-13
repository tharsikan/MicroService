package com.db.jpademo2.service;

import java.util.List;

import com.db.jpademo2.model.Employee;
import com.db.pojo.Allocation;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    Employee getEmployee(Long id);
    Allocation saveAllocation(Long employee_id,Allocation allocation);
    Allocation[] getAllAllocation(Long employee_id);
}
