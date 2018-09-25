package com.metacube.training.dao;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.dao.interfaces.RoleDAO;
import com.metacube.training.model.UserRole;

@Repository
@Transactional
public class RoleDAOImpl implements RoleDAO
{
	@Autowired
	private SessionFactory sessionFactory;
	
	public UserRole getRoleByEmpCode(String empCode)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(UserRole.class);
		criteria.add(Restrictions.eq("empCode", empCode));
		return (UserRole) criteria.uniqueResult();
	}
}