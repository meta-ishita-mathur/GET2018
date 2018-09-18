package com.metacube.training.service;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Skill;
import com.metacube.training.repository.SkillRepository;
import com.metacube.training.service.interfaces.SkillService;

@Service
public class SkillServiceImpl implements SkillService
{	
	@Autowired
	private SkillRepository<Skill> skillRepository;

	public List<Skill> getAllSkills()
	{
		return skillRepository.findAll();
	}

	public boolean createSkill(Skill skill)
	{
		return skillRepository.save(skill);
	}
	
	public boolean insertInSkillRelation(EmployeeSkill skill)
	{
		return skillRepository.save(skill);
	}
	
	public Skill getSkillById(int id)
	{
		return skillRepository.findOne(id);
	}
}
