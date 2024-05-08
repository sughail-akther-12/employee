package io.bizsense.employee.repository;

import io.bizsense.employee.model.EmployeeAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeAddressRepository extends JpaRepository<EmployeeAddress, Long> {

    List<EmployeeAddress> findByEmployeeId(Long employeeId);
}
