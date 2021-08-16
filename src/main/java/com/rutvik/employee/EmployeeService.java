package com.rutvik.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }

    public Employee getEmployeeById(String id) {
        return employees.stream().filter(t -> t.getEmail().equals(id)).findFirst().get();
    }

    public void addEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public void updateEmployee(String id, Employee employee) {
        if(employeeRepository.findById(Integer.parseInt(id)).isPresent()) {
            employeeRepository.save(employee);
        }
    }

    public void deleteEmployee(String id) {
        employeeRepository.deleteById(Integer.parseInt(id));
    }
}
