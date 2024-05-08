package io.bizsense.employee.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class EmployeeAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    private String street;
    private String city;
    private String state;
    private Integer postalCode;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Long getId() {
        return id;
    }

    public EmployeeAddress setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public EmployeeAddress setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getCity() {
        return city;
    }

    public EmployeeAddress setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public EmployeeAddress setState(String state) {
        this.state = state;
        return this;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public EmployeeAddress setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    public Employee getEmployee() {
        return employee;
    }

    public EmployeeAddress setEmployee(Employee employee) {
        this.employee = employee;
        return this;
    }
}
