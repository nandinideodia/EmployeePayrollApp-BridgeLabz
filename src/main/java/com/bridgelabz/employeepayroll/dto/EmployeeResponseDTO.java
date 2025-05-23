package com.bridgelabz.employeepayroll.dto;

public record EmployeeResponseDTO(
    Long id,
    String name,
    double salary,
    String department
) {}