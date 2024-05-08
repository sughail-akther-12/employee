package io.bizsense.employee.service;

import io.bizsense.employee.model.Employee;
import io.bizsense.employee.model.EmployeeAddress;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeAddressService {

    EmployeeAddress createEmployeeAddress(EmployeeAddress request);

    EmployeeAddress updateEmployeeAddress(Long id, EmployeeAddress request);

    List<EmployeeAddress> getAddressByEmployeeId(Long id);
}
