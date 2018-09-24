package com.metacube.training.dao.interfaces;

import java.util.List;

import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;

public interface SkillDAO
{
	public List<Skill> getAllSkills();
	
	public boolean createSkill(Skill skill);
	
	public Skill getSkillById(int id);

	public boolean insertInSkillRelation(EmployeeSkill skill);
}
