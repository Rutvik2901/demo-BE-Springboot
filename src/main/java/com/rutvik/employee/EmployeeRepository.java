package com.rutvik.employee;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, String> {
    Optional<Object> findById(Integer id);

    void deleteById(Integer id);
}
