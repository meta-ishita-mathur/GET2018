package com.metacube.training.service.interfaces;

import java.util.List;
import com.metacube.training.model.UserRole;

public interface RoleService
{
	public List<UserRole> getRoleByEmpCode(String empCode);
}