package com.bridgelabz.employeepayroll.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record EmployeeRequestDTO(
	@NotBlank(message = "Employee name is mandatory")
	@Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
	@Pattern(
	        regexp = "^[\\p{L} .'-]+$", 
	        message = "Name can only contain letters, spaces, apostrophes, hyphens, and dots") 
	String name,
    @Min(1000) double salary,
    String department
) {
    // Optional: Add getter-style methods if preferred
    public String getName() { return name(); }
    public double getSalary() { return salary(); }
    public String getDepartment() { return department(); }
}