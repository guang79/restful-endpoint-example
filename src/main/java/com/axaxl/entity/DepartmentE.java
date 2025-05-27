package com.axaxl.entity;

public enum DepartmentE {

    HR(100L, "HR"),
    BUSINESS(200L, "BUSINESS"),
    ENGINEERING(300L, "ENGINEERING");

    Long id;
    String name;

    private DepartmentE(Long id, String name) {
        this.id = id;
        this.name = name;
    }

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
