package com.metacube.training.dao.interfaces;

import com.metacube.training.model.UserRole;

public interface RoleDAO
{
	public UserRole getRoleByEmpCode(String empCode);
}