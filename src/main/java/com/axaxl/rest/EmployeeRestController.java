package com.axaxl.rest;

import com.axaxl.entity.Department;
import com.axaxl.entity.Employee;
import com.axaxl.repository.EmployeeRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/api/employee", produces = {MediaType.APPLICATION_JSON_VALUE})
@Tag(name = "EmployeeRestController")
public class EmployeeRestController {

    private final EmployeeRepository employeeRepository;

    public EmployeeRestController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    @Operation(operationId = "getAllEmployees", summary = "GetAllEmployees()")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/{id}")
    @Operation(operationId = "getEmployeeById", summary = "GetEmployeeById()")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/ids/{ids}")
    @Operation(operationId = "getEmployeeByIds", summary = "GetEmployeeByIds()")
    public ResponseEntity<List<Employee>> getEmployeeByIds(@PathVariable("ids") List<Long> ids) {
        List<Employee> employees = employeeRepository.findAllById(ids);
        return ResponseEntity.ok(employees);
    }

    @PostMapping("/update")
    @Operation(operationId = "updateEmployee", summary = "UpdateEmployee()")
    public ResponseEntity<String> updateEmployee(@RequestBody Employee employee) {
        if(!checkIfNotNull(employee)) {
            return ResponseEntity.badRequest().build();
        }
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("Update Employee Successfully!!!");
    }

    @PostMapping("/update/salary/{id}/{salary}")
    @Operation(operationId = "updateEmployeeSalaryById", summary = "UpdateEmployeeSalaryById()")
    public ResponseEntity<String> updateEmployeeSalaryById(@PathVariable Long id, @PathVariable Double salary) {
        Optional<Employee> optional = employeeRepository.findById(id);
        if(optional.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        Employee employee = optional.get();
        employee.setSalary(salary);
        employeeRepository.save(employee);
        return ResponseEntity.ok().body("Update Employee Salary Successfully!!!");
    }

    @DeleteMapping("/delete/{id}")
    @Operation(operationId = "deleteEmployeeById", summary = "DeleteEmployeeById()")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeRepository.deleteById(id);
        return ResponseEntity.ok().body("Delete Employee Successfully!!!");
    }

    private boolean checkIfNotNull(Employee employee) {
        return !StringUtils.isBlank(employee.getFirstName())
                && !StringUtils.isBlank(employee.getLastName())
                && !StringUtils.isBlank(employee.getEmail())
                && !StringUtils.isBlank(String.valueOf(employee.getDepartmentId()));
    }

}
