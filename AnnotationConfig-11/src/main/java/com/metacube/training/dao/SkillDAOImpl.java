package com.metacube.training.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.model.EmployeeSkill;
import com.metacube.training.model.Project;
import com.metacube.training.model.Skill;

@Repository
@Transactional
public class SkillDAOImpl implements SkillDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Skill> getAllSkills()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		return criteria.list();
	}

	public boolean createSkill(Skill skill)
	{
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}
	
	public Skill getSkillById(int id)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Skill.class);
		criteria.add(Restrictions.eq("id", id));
		return (Skill) criteria.uniqueResult();
	}
	
	public boolean insertInSkillRelation(EmployeeSkill skill)
	{
		sessionFactory.getCurrentSession().save(skill);
		return true;
	}
}