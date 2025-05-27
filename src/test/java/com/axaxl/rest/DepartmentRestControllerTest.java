package com.axaxl.rest;

import com.axaxl.entity.Department;
import com.axaxl.repository.DepartmentRepository;
import com.axaxl.configuration.ObjectMapperConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DepartmentRestController.class)
@AutoConfigureMockMvc
@Import(ObjectMapperConfiguration.class)
@ActiveProfiles("test")
public class DepartmentRestControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private DepartmentRepository departmentRepository;

    @Test
    void testGetDepartmentById() throws Exception {
        when(departmentRepository.findById(100L)).thenReturn(Optional.of(new Department(100L, "HR")));

        mockMvc.perform(get("/api/department/100"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("HR"));
    }

}
