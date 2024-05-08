package io.bizsense.employee.service;

import io.bizsense.employee.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeService {

    Employee createEmployee(Employee employee);

    Employee updateEmployee(Long id, Employee employee);

    Employee getEmployeeById(Long id);

    List<Employee> getAllEmployees(String keyword);

    boolean deleteEmployee(Long id);
}
