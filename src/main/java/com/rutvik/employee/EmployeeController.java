package com.rutvik.employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

//
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping("/employee")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }


    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.POST,value="/employee")
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @RequestMapping(method = RequestMethod.PUT, value = "/employee/{id}")
    public void updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id,employee);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @Transactional
    @RequestMapping(method = RequestMethod.DELETE, value = "/employee/{id}")
    public void updateEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
