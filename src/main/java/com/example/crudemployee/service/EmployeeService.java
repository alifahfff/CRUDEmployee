package com.example.crudemployee.service;

import com.example.crudemployee.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllPeople();
    Employee findById(long id);
    List<Employee> findByIds(List<Long> id);

    Employee insert(Employee p);
    List<Employee> insertAll(List<Employee> p);

    boolean delete(Long id);
    boolean deleteAll(List<Employee> ids);

    boolean update(Employee
                           p);
    boolean updateAll(List<Employee> p);
}