package com.axaxl.repository;

import com.axaxl.entity.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.*;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        Employee e1 = new Employee("Jason", "Kim", "111-111-1111", "Jason@axaxl.com", 1000.00, 300L, "Senior Software Engineer");
        employeeRepository.save(e1);
    }

    @Test
    void testFindByEmail() {
        Optional<Employee> employee = employeeRepository.findByEmail("Jason@axaxl.com");
        assertThat(employee).isPresent();
        assertThat(employee.get().getEmail()).isEqualTo("Jason@axaxl.com");
    }

}
