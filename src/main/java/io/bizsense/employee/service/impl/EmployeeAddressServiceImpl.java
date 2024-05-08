package io.bizsense.employee.service.impl;

import io.bizsense.employee.model.Employee;
import io.bizsense.employee.model.EmployeeAddress;
import io.bizsense.employee.repository.EmployeeAddressRepository;
import io.bizsense.employee.repository.EmployeeRepository;
import io.bizsense.employee.service.EmployeeAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAddressServiceImpl implements EmployeeAddressService {

    @Autowired private EmployeeAddressRepository employeeAddressRepository;
    @Autowired private EmployeeRepository employeeRepository;

    @Override
    public EmployeeAddress createEmployeeAddress(EmployeeAddress request) {
        if(request.getEmployee() != null) {
            Long employeeId = request.getEmployee().getId();
            Employee requestEmployee = employeeRepository.findById(employeeId).orElse(null);
            request.setEmployee(requestEmployee);
        }
        return employeeAddressRepository.save(request);
    }

    @Override
    public EmployeeAddress updateEmployeeAddress(Long id, EmployeeAddress employeeAddress) {
        Optional<EmployeeAddress> optionalEmployeeAddress = employeeAddressRepository.findById(id);
        if (optionalEmployeeAddress.isPresent()) {
            EmployeeAddress existingAddress = optionalEmployeeAddress.get();
            existingAddress.setStreet(employeeAddress.getStreet())
                    .setCity(employeeAddress.getCity())
                    .setState(employeeAddress.getState())
                    .setPostalCode(employeeAddress.getPostalCode());
            return employeeAddressRepository.save(existingAddress);
        } else {
            return null;
        }
    }

    @Override
    public List<EmployeeAddress> getAddressByEmployeeId(Long employeeId) {
        return employeeAddressRepository.findByEmployeeId(employeeId);
    }
}
