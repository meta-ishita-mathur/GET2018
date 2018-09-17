package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.metacube.training.model.Employee;

/**
 * the class defines repository class for employee
 */
public interface EmployeeRepository<E> extends JpaRepository<Employee, Integer>
{
	public List<Employee> getAllEmployee();
	public Employee getEmployeeByEmailId(Employee employee);
	public Employee getLastAddedEmployee();

	@Query("SELECT E FROM Employee E, Skill S, EmployeeSkill ES WHERE E.empCode = ES.employeeCode AND ES.skillCodeTable = S.id AND S.name = :skillName ")
	public List<Employee> getEmployeesBySkill(@Param("skillName")String name);
}