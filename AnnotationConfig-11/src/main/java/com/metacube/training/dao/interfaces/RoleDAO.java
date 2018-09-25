package com.metacube.training.dao.interfaces;

import java.util.List;
import com.metacube.training.model.UserRole;

public interface RoleDAO
{
	public List<UserRole> getRoleByEmpCode(String empCode);
}