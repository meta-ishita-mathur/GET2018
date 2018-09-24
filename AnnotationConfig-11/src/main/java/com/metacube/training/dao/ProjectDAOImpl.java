package com.metacube.training.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.ProjectDAO;
import com.metacube.training.model.Project;

@Repository
@Transactional
public class ProjectDAOImpl implements ProjectDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public Project getProjectById(int id)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
		criteria.add(Restrictions.eq("id", id));
		return (Project) criteria.uniqueResult();
	}

	public List<Project> getAllProjects()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Project.class);
		return criteria.list();
	}

	public boolean deleteProject(Project project)
	{
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("delete from Project where id = :id");
		query.setParameter("id", project.getId());
		return query.executeUpdate() > 0;
	}

	public boolean updateProject(Project project)
	{		
		TypedQuery<Project> query = sessionFactory.getCurrentSession().createQuery("update Project set name = :name, description = :description, startDate = :startDate, endDate = :endDate where id = :id");
		query.setParameter("name", project.getName());
		query.setParameter("description", project.getDescription());
		query.setParameter("startDate", project.getStartDate());
		query.setParameter("endDate", project.getEndDate());
		query.setParameter("id", project.getId());
		return query.executeUpdate() > 0;
	}

	public boolean createProject(Project project)
	{
		sessionFactory.getCurrentSession().save(project);
		return true;
	}
}