package com.axaxl.entity;


import jakarta.persistence.*;

@Entity
//@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "phone_number", length = 100)
    private String phoneNumber;

    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String email;

    @Column(name = "salary")
    private Double salary;

    //@ManyToOne
    //@JoinColumn(name = "department_id", nullable = false)
    @Column(name = "department_id", nullable = false)
    private Long departmentId;

    @Column(name = "job_title", length = 100)
    private String jobTitle;

    @Column(name = "is_current")
    private boolean isCurrent = true;

    public Employee() {}

    public Employee(String firstName, String lastName, String phoneNumber, String email, Double salary, Long departmentId, String jobTitle) {
        this(firstName, lastName, phoneNumber, email, salary, departmentId, jobTitle, true);
    }

    public Employee(String firstName, String lastName, String phoneNumber, String email, Double salary, Long departmentId, String jobTitle, boolean isCurrent) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.salary = salary;
        this.departmentId = departmentId;
        this.jobTitle = jobTitle;
        this.isCurrent = isCurrent;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Long getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isCurrent() {
        return isCurrent;
    }

    public void setIsCurrent(boolean current) {
        isCurrent = current;
    }

}
