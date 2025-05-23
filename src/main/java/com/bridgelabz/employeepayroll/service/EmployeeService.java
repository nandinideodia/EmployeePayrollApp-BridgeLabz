package com.bridgelabz.employeepayroll.service;

import com.bridgelabz.employeepayroll.dto.EmployeeRequestDTO;
import com.bridgelabz.employeepayroll.dto.EmployeeResponseDTO;
import com.bridgelabz.employeepayroll.exception.EmployeeNotFoundException;
import com.bridgelabz.employeepayroll.model.Employee;
import com.bridgelabz.employeepayroll.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeResponseDTO createEmployee(EmployeeRequestDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setName(employeeDTO.name());
        employee.setSalary(employeeDTO.salary());
        employee.setDepartment(employeeDTO.department());
        
        Employee savedEmployee = employeeRepository.save(employee);
        return mapToDTO(savedEmployee);
    }

    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        return mapToDTO(employee);
    }

    public List<EmployeeResponseDTO> getAllEmployees() {
        return employeeRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public EmployeeResponseDTO updateEmployee(Long id, EmployeeRequestDTO employeeDTO) {
        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));
        
        existingEmployee.setName(employeeDTO.name());
        existingEmployee.setSalary(employeeDTO.salary());
        existingEmployee.setDepartment(employeeDTO.department());
        
        Employee updatedEmployee = employeeRepository.save(existingEmployee);
        return mapToDTO(updatedEmployee);
    }

    public void deleteEmployee(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException(id);
        }
        employeeRepository.deleteById(id);
    }

    private EmployeeResponseDTO mapToDTO(Employee employee) {
        return new EmployeeResponseDTO(
            employee.getId(),
            employee.getName(),
            employee.getSalary(),
            employee.getDepartment()
        );
    }
}