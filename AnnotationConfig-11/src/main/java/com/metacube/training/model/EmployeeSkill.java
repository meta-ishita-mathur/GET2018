package com.metacube.training.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee_skill")
public class EmployeeSkill
{
	@Id
	@Column(name = "emp_skill_id")
	private int empSkillId;
	
	@Column(name = "emp_code")
	private String employeeCode;
	
	@Column(name = "skill_code")
	private int skillCodeTable;
	
	
	public int getSkillCodeTable()
	{
		return skillCodeTable;
	}

	public void setSkillCodeTable(int skillCodeTable)
	{
		this.skillCodeTable = skillCodeTable;
	}

	public String getEmpCodeTable() 
	{
		return employeeCode;
	}

	public void setEmployeeCodeTable(String employeeCode)
	{
		this.employeeCode = employeeCode;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "emp_code", insertable = false, updatable = false)
	private Employee empCode;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skill_code", insertable = false, updatable = false)
    private Skill skillCode;
	
	public int getEmpSkillId() 
	{
        return empSkillId;
    }

    public void setEmpSkillId(int empSkillId)
    {
        this.empSkillId = empSkillId;
    }

    public Employee getEmployeeCode()
    {
        return empCode;
    }

    public void setEmployeeCode(Employee empCode)
    {
        this.empCode = empCode;
    }

    public Skill getSkillCode()
    {
        return skillCode;
    }

    public void setSkillCode(Skill skillCode)
    {
        this.skillCode = skillCode;
    }
}