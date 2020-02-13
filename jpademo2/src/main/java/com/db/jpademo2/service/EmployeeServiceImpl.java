package com.db.jpademo2.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.db.jpademo2.model.Employee;
import com.db.jpademo2.model.Telephone;
import com.db.jpademo2.repository.EmployeeRepository;
import com.db.pojo.Allocation;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	RestTemplate restTemplate;
	
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee saveEmployee(Employee employee) {
        for(Telephone telephone :employee.getTelephoneList()){
            telephone.setEmployee(employee);
        }
        return employeeRepository.save(employee);
    }
	@Override
	public Allocation saveAllocation(Long employee_id,Allocation allocation) {
		
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Allocation> entity = new HttpEntity<Allocation>(allocation,httpheader);
	      
		String url = "http://localhost:8082/"+employee_id+"/allocation/";
		
	      return restTemplate.exchange(url, HttpMethod.POST, entity, Allocation.class).getBody();
	}
	@Override
	public Allocation[] getAllAllocation(Long employee_id) {
		HttpHeaders httpheader = new HttpHeaders();
		httpheader.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<Allocation> entity = new HttpEntity<Allocation>(httpheader);
	      
		String url = "http://localhost:8082/"+employee_id+"/allocation/";
		
	      return restTemplate.exchange(url, HttpMethod.GET, entity, Allocation[].class).getBody();
	}
	
	@Override
	public Employee getEmployee(Long id) {
		Optional<Employee> optionalemployee = employeeRepository.findById(id);
		if(optionalemployee.isPresent()) {
			Employee employee = optionalemployee.get();
			employee.setAllocations(getAllAllocation(id));
			return employee;
		}
		return null;
	}
}