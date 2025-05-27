package com.axaxl.entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "department")
public class Department {

    @Id
    private Long id;

    @Column(nullable = false, length = 50)
    private String name;

    public Department() {}

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

}
