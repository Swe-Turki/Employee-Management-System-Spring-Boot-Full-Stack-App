package com.example.frontend.controller;

import com.example.frontend.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class EmployeeViewController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> employees = Arrays.asList(
            restTemplate.getForObject("http://localhost:8080/api/employees", Employee[].class)
        );
        model.addAttribute("employees", employees);
        return "employee-list";
    }

    @GetMapping("/add-employee")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "add-employee";
    }

    @PostMapping("/add-employee")
    public String saveEmployee(@ModelAttribute Employee employee) {
        restTemplate.postForObject("http://localhost:8080/api/employees", employee, Employee.class);
        return "redirect:/employees";
    }

    @GetMapping("/edit-employee/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        Employee employee = restTemplate.getForObject("http://localhost:8080/api/employees/" + id, Employee.class);
        model.addAttribute("employee", employee);
        return "edit-employee";
    }

    @PostMapping("/edit-employee/{id}")
    public String updateEmployee(@PathVariable Long id, @ModelAttribute Employee employee) {
        restTemplate.put("http://localhost:8080/api/employees/" + id, employee);
        return "redirect:/employees";
    }

    @GetMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        restTemplate.delete("http://localhost:8080/api/employees/" + id);
        return "redirect:/employees";
    }
}
