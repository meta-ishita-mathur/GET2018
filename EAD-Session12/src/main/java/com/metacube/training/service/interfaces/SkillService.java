package com.metacube.training.service.interfaces;

import java.util.List;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;

public interface SkillService
{
	public List<Skill> getAllSkills();
	
	public boolean createSkill(Skill skill);
	
	public boolean insertInSkillRelation(EmployeeSkill skill);
	
	public Skill getSkillById(int id);
}