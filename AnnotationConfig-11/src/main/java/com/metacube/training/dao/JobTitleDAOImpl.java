package com.metacube.training.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.interfaces.JobTitleDAO;
import com.metacube.training.model.JobTitle;

@Repository
@Transactional
public class JobTitleDAOImpl implements JobTitleDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<JobTitle> getAllJobTitle()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		return criteria.list();
	}
	
	public boolean deleteJobTitle(int id)
	{
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("delete from JobTitle where id = :id");
		query.setParameter("id", id);
		return query.executeUpdate() > 0;
	}

	public boolean updateJobTitle(JobTitle jobTitle)
	{
		TypedQuery<JobTitle> query = sessionFactory.getCurrentSession().createQuery("UPDATE JobTitle SET job_title = :jobTitle WHERE job_id = :id");
		query.setParameter("job_title", jobTitle.getJobTitle());
		query.setParameter("job_id", jobTitle.getId());
		return query.executeUpdate() > 0;
	}

	public boolean createJobTitle(JobTitle jobTitle)
	{
		sessionFactory.getCurrentSession().save(jobTitle);
		return true;
	}
	
	public JobTitle getJobTitleById(int id)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(JobTitle.class);
		criteria.add(Restrictions.eq("job_id", id));
		JobTitle jobTitle = (JobTitle) criteria.uniqueResult();
		return jobTitle;
	}
}