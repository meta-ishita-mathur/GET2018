package com.metacube.training.service;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;
import com.metacube.training.service.interfaces.SkillService;

@Service
public class SkillServiceImpl implements SkillService
{
	@Autowired
	SkillDAO skillDAO;

	public List<Skill> getAllSkills()
	{
		return skillDAO.getAllSkills();
	}

	public boolean createSkill(Skill skill)
	{
		return skillDAO.createSkill(skill);
	}
	
	public boolean insertInSkillRelation(EmployeeSkill skill)
	{
		return skillDAO.insertInSkillRelation(skill);
	}
	
	public Skill getSkillById(int id)
	{
		return skillDAO.getSkillById(id);
	}
}