package com.axaxl.rest;

import com.axaxl.entity.Department;
import com.axaxl.repository.DepartmentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@RestController
@RequestMapping(value="/api/department", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "DepartmentRestController")
public class DepartmentRestController {

    private final DepartmentRepository departmentRepository;

    public DepartmentRestController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    @Operation(operationId = "getAllDepartments", summary = "GetAllDepartments()")
    public ResponseEntity<List<Department>> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/{id}")
    @Operation(operationId = "getDepartmentById", summary = "GetDepartmentById()")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
        return departmentRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ids/{ids}")
    @Operation(operationId = "getDepartmentByIds", summary = "GetDepartmentByIds()")
    public ResponseEntity<List<Department>> getDepartmentByIds(@PathVariable("ids") List<Long> ids) {
        List<Department> departments = departmentRepository.findAllById(ids);
        return ResponseEntity.ok(departments);
    }
    
    @PostMapping("/update")
    @Operation(operationId = "updateDepartment", summary = "UpdateDepartment()")
    public ResponseEntity<String> updateDepartment(@RequestBody Department department) {
        if(department.getId() == null || StringUtils.isBlank(department.getName())) {
            return ResponseEntity.badRequest().build();
        }
        departmentRepository.save(department);
        return ResponseEntity.ok().body("Update Department Successfully!!!");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(operationId = "deleteDepartmentById", summary = "DeleteDepartmentById()")
    public ResponseEntity<String> deleteDepartmentById(@PathVariable Long id) {
        departmentRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete Department Successfully!!!");
    }

}
