package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayroll.dto.EmployeeResponseDTO;
import java.util.List;

public interface IEmployeeService {
    EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeDTO);
    EmployeeResponseDTO getEmployeeById(Long id);
    List<EmployeeResponseDTO> getAllEmployees();
    EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeDTO);
    void deleteEmployee(Long id);
}