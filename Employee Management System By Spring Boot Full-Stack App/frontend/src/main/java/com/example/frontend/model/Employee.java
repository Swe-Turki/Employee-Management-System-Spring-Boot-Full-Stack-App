package com.example.frontend.model;

public class Employee {

    public static void updateEmployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    private Long id;
    private String name;
    private double salary;
    private String email;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getSalary() { return salary; }
    public void setSalary(double salary) { this.salary = salary; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
