package com.metacube.training.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.dao.interfaces.EmployeeDAO;
import com.metacube.training.model.Employee;
import com.metacube.training.model.EmployeeSkill;

@Repository
@Transactional
public class EmployeeDAOImpl implements EmployeeDAO
{
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employee> getAllEmployee()
	{	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		return criteria.list();
	}

	public boolean createEmployee(Employee employee)
	{
		sessionFactory.getCurrentSession().save(employee);
		return true;
	}

	public Employee getLastAddedEmployee()
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.addOrder(Order.desc("empCode"));
		criteria.setMaxResults(1);
		return (Employee) criteria.uniqueResult();
	}
	
	public Employee getEmployeeById(Employee employee)
	{	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empCode", employee.getEmpCode()));
		return (Employee) criteria.uniqueResult();
	}

	public Employee getEmployeeByEmailId(Employee employee)
	{	
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("emailId", employee.getEmailId()));
		return (Employee) criteria.uniqueResult();
	}
	
	public boolean addJobDetails(Employee employee)
	{
		return false;
	}

	public boolean toggleActivation()
	{
		return false;
	}
	
	public List<Employee> getEmployeesBySkill(String skill)
	{
		List<Employee> listOfEmployee = new ArrayList<Employee>();
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(EmployeeSkill.class, "employee");
        criteria.createAlias("employee.skillCode", "skill");
        criteria.add(Restrictions.like("skill.name", skill + "%"));

        for(Object empSkill: criteria.list())
        {
            EmployeeSkill es = (EmployeeSkill) empSkill;
            listOfEmployee.add(es.getEmployeeCode());
        }
        return listOfEmployee;
	}
	
	public boolean addSkill(EmployeeSkill employeeSkill)
	{
		sessionFactory.getCurrentSession().save(employeeSkill);
		return true;
	}
	
	public Employee findByEmpCodeAndPassword(String empCode, String password)
	{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Employee.class);
		criteria.add(Restrictions.eq("empCode", empCode));
		criteria.add(Restrictions.eq("password", password));
		return (Employee) criteria.uniqueResult();
	}
}