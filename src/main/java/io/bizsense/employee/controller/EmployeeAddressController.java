package io.bizsense.employee.controller;

import io.bizsense.employee.model.EmployeeAddress;
import io.bizsense.employee.service.EmployeeAddressService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Address", description = "Employee Address Api")
@RestController
@RequestMapping("/api/employeeAddress")
public class EmployeeAddressController {

    @Autowired private EmployeeAddressService employeeAddressService;

    @Operation(summary = "Create new Employee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successful operation")
    })
    @PostMapping
    public ResponseEntity<EmployeeAddress> createEmployeeAddress(@RequestBody EmployeeAddress request) {
        EmployeeAddress createdAddress = employeeAddressService.createEmployeeAddress(request);
        return new ResponseEntity<>(createdAddress, HttpStatus.CREATED);
    }

    @Operation(summary = "Update Employee by Id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @PutMapping("/{id}")
    public ResponseEntity<EmployeeAddress> updateEmployeeAddress(@PathVariable Long id, @RequestBody EmployeeAddress request) {
        EmployeeAddress updatedEmployeeAddress = employeeAddressService.updateEmployeeAddress(id, request);
        if (updatedEmployeeAddress != null) {
            return new ResponseEntity<>(updatedEmployeeAddress, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Operation(summary = "Get Address by Employee ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation"),
            @ApiResponse(responseCode = "404", description = "employee not found")
    })
    @GetMapping("/employee/{id}")
    public ResponseEntity<List<EmployeeAddress>> getAddressByEmployeeId(@PathVariable Long id) {
        List<EmployeeAddress> addresses = employeeAddressService.getAddressByEmployeeId(id);
        if (!addresses.isEmpty()) {
            return new ResponseEntity<>(addresses, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
