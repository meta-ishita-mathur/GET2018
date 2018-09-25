package com.metacube.training.service.interfaces;

import com.metacube.training.model.UserRole;

public interface RoleService
{
	public UserRole getRoleByEmpCode(String empCode);
}