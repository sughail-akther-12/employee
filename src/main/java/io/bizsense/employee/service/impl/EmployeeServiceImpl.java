package io.bizsense.employee.service.impl;

import io.bizsense.employee.model.Employee;
import io.bizsense.employee.model.EmployeeAddress;
import io.bizsense.employee.repository.EmployeeRepository;
import io.bizsense.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(Employee request) {
        if(request.getAddress() != null) {
            for(EmployeeAddress address : request.getAddress()) {
                address.setEmployee(request);
            }
        }
        return employeeRepository.save(request);
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Employee requestEmployee = employeeRepository.findById(id).orElse(null);
        if(requestEmployee != null) {
            requestEmployee
                    .setFirstName(employee.getFirstName())
                    .setLastName(employee.getLastName())
                    .setEmail(employee.getEmail())
                    .setPhoneNumber(employee.getPhoneNumber())
                    .setAddress(employee.getAddress());
            return employeeRepository.save(requestEmployee);
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(Long id) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        return optionalEmployee.orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees(String keyword) {
        List<Employee> employees = employeeRepository.findAll();
        if (keyword != null && !keyword.isEmpty()) {
            employees = employees.stream()
                    .filter(employee -> employee.getFirstName().toLowerCase().contains(keyword.toLowerCase()))
                    .collect(Collectors.toList());
        }
        employees.sort(Comparator.comparing(Employee::getFirstName));
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        if (getEmployeeById(id) != null ) {
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
