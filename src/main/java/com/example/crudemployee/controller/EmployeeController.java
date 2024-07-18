package com.example.crudemployee.controller;

import com.example.crudemployee.model.Employee;
import com.example.crudemployee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/api/employee")
public class EmployeeController {

    private static final String REQUEST_NO_BODY = "Request does not contain a body";

    @Autowired
    EmployeeService peopleService;

    @GetMapping("")
    public List<Employee> getAllPeople() {
        return peopleService.findAllPeople();
    }

    @GetMapping("{id}")
    public Employee getPerson(@PathVariable long id) {
        return peopleService.findById(id);
    }

    @PostMapping("")
    public String addPerson(@RequestBody Employee person) {
        if(person != null) {
            peopleService.insert(person);
            return "Added a person";
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @PostMapping("bulk")
    public String addPeople(@RequestBody List<Employee> people) {
        if(people != null && !people.isEmpty()) {
            peopleService.insertAll(people);
            return String.format("Added %d people.", people.size());
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @DeleteMapping("{id}")
    public String deletePerson(@PathVariable("id") long id) {
        if(id > 0) {
            if(peopleService.delete(id)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The id is invalid for the person.";
    }

    @DeleteMapping("bulk")
    public String deletePeople(@RequestBody List<Employee> ids) {
        if(!ids.isEmpty()) {
            if(peopleService.deleteAll(ids)) {
                return "Deleted the person.";
            } else {
                return "Cannot delete the person.";
            }
        }
        return "The request should contain a list of people to be deleted.";
    }

    @PutMapping("")
    public String updatePerson(@RequestBody Employee person) {
        if(person != null) {
            peopleService.update(person);
            return "Updated person.";
        } else {
            return REQUEST_NO_BODY;
        }
    }

    @PutMapping("bulk")
    public String updatePeople(@RequestBody List<Employee> people) {
        if(people != null) {
            peopleService.updateAll(people);
            return "Updated people.";
        } else {
            return REQUEST_NO_BODY;
        }
    }
}
