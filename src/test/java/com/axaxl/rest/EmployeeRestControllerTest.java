package com.axaxl.rest;

import com.axaxl.entity.Employee;
import com.axaxl.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeRestController.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class EmployeeRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private EmployeeRepository employeeRepository;

    @Test
    void testGetEmployeeById() throws Exception {
        Employee e1 = new Employee("Jason", "Kim", "111-111-1111", "Jason@axaxl.com", 1000.00, 300L, "Senior Software Engineer");
        when(employeeRepository.findById(1L)).thenReturn(Optional.of(e1));
        mockMvc.perform(get("/api/employee/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email").value("Jason@axaxl.com"));
    }

}
