package com.metacube.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.dao.interfaces.RoleDAO;
import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.model.UserRole;
import com.metacube.training.service.interfaces.RoleService;

@Service
public class RoleServiceImpl implements RoleService
{
	@Autowired
	RoleDAO roleDAO;
	
	public UserRole getRoleByEmpCode(String empCode)
	{
		return roleDAO.getRoleByEmpCode(empCode);
	}
}