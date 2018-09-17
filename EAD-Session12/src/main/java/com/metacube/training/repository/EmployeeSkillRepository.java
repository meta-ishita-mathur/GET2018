package com.metacube.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.metacube.training.model.EmployeeSkill;

public interface EmployeeSkillRepository<E> extends JpaRepository<EmployeeSkill, Integer>
{

}
