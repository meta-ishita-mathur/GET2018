package com.metacube.training.configuration;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import com.metacube.training.model.UserRole;
import com.metacube.training.service.interfaces.RoleService;
import com.metacube.training.service.interfaces.EmployeeService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider
{
	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RoleService roleService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException
	{
		UsernamePasswordAuthenticationToken authenticate = (UsernamePasswordAuthenticationToken) authentication;
		String empCode = String.valueOf(authenticate.getPrincipal());
		String password = String.valueOf(authenticate.getCredentials());

		if (!employeeService.checkValidCredentials(empCode, password))
		{
			throw new BadCredentialsException("External system authentication failed");
		}

		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		List<UserRole> roleList = roleService.getRoleByEmpCode(empCode);

		for (UserRole role : roleList)
		{
			roles.add(new SimpleGrantedAuthority(role.getRole()));
		}
		return new UsernamePasswordAuthenticationToken(empCode, password, roles);
	}

	@Override
	public boolean supports(Class<?> authentication)
	{
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}