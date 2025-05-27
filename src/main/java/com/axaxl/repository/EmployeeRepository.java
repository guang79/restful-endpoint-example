package com.axaxl.repository;

import com.axaxl.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByFirstNameIgnoreCase(String firstName);

    List<Employee> findByFirstNameContaining(String firstName);

    Optional<Employee> findByEmail(String email);

    boolean existsByEmail(String email);

    List<Employee> findBySalaryGreaterThan(Double salary);

    @Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :minSalary AND :maxSalary")
    List<Employee> findByEmployeesBySalaryRange(@Param("minSalary") Double minSalary, @Param("maxSalary") Double maxSalary);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e SET e.salary = :salary WHERE e.id = :id")
    int updateSalary(@Param("id") Long employeeId, @Param("salary") Double newSalary);

    List<Employee> findByDepartmentId(Long departmentId);

    Long countByDepartmentId(Long departmentId);

}
