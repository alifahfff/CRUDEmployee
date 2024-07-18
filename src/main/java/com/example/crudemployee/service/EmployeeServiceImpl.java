package com.example.crudemployee.service;

import com.example.crudemployee.model.Employee;
import com.example.crudemployee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> findAllPeople() {
        return (List<Employee>)repository.findAll();
    }

    @Override
    public Employee findById(long id) {
        Optional<Employee> result = repository.findById(id);
        if (result.isPresent()) {
            return result.get();
        } else {
            return null;
        }
    }

    @Override
    public List<Employee> findByIds(List<Long> ids) {
        return (List<Employee>)repository.findAllById(ids);
    }

    @Override
    public Employee insert(Employee p) {
        return repository.save(p);
    }

    @Override
    public List<Employee> insertAll(List<Employee> p) {
        return (List<Employee>)repository.saveAll(p);
    }

    @Override
    public boolean delete(Long id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean deleteAll(List<Employee> ids) {

        try {
            repository.deleteAll(ids);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(Employee p) {

        try {
            repository.save(p);
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean updateAll(List<Employee> p) {
        try {
            repository.saveAll(p);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
