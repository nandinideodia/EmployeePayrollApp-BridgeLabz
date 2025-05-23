package com.bridgelabz.employeepayroll.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
// import lombok.Data; // REMOVE THIS IMPORT

// REMOVE @Data annotation
@Entity
public class Employee {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private double salary;
    private String department;

    // --- Getters and Setters ---

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // --- Optional: toString(), equals(), hashCode() methods ---
    // If you remove @Data, you also lose the default toString(), equals(), hashCode().
    // For simple entities, these might not be strictly necessary for basic API functionality,
    // but they are good practice for logging, debugging, and collections.

    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary=" + salary +
               ", department='" + department + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Double.compare(salary, employee.salary) == 0 &&
               id.equals(employee.id) &&
               name.equals(employee.name) &&
               department.equals(employee.department);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, name, salary, department);
    }
}