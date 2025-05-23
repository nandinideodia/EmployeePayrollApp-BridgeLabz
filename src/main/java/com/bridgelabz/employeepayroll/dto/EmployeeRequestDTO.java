package com.bridgelabz.employeepayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record EmployeeRequestDTO(
    @NotBlank String name,
    @Min(1000) double salary,
    String department
) {
    // Optional: Add getter-style methods if preferred
    public String getName() { return name(); }
    public double getSalary() { return salary(); }
    public String getDepartment() { return department(); }
}