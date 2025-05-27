package com.axaxl.repository;

import com.axaxl.entity.Department;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

@DataJpaTest
@ActiveProfiles("test")
public class DepartmentRepositoryTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department d1 = new Department(1L, "Test");
        departmentRepository.save(d1);
    }

    @Test
    public void testFindById() {
        Optional<Department> department = departmentRepository.findById(1L);
        assertThat(department).isPresent();
        assertThat(department.get().getName()).isEqualTo("Test");
    }

}
