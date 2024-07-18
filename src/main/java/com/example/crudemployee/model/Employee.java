package com.example.crudemployee.model;

import jakarta.persistence.*;

@Entity
@Table(name = "people")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    public Long id;

    @Column(name = "name")
    public String name;

    @Column(name = "role")
    public String role;

    public Employee() {}

    public Employee(long id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append(String.valueOf(id));
        builder.append(", ");
        builder.append(name);
        builder.append(", ");
        builder.append(role);

        return builder.toString();
    }
}