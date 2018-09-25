package com.metacube.training.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	CustomAuthenticationProvider customAuthenticationProvider;
	
/*
	@Autowired
	DataSource dataSource;
	
	//usingDB
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticate) throws Exception
	{
		authenticate.jdbcAuthentication().dataSource(dataSource).passwordEncoder(NoOpPasswordEncoder.getInstance())
		.usersByUsernameQuery("select emp_code, password, enabled from employee where emp_code = ?")
		.authoritiesByUsernameQuery("select emp_code, role from user_role where emp_code = ?");
	}*/
	
	//usingCustomDB
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticate) throws Exception
	{
		authenticate.authenticationProvider(customAuthenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/admin/*")
				.access("hasRole('ROLE_ADMIN')")
				.antMatchers("/employee/*")
				.access("hasRole('ROLE_EMPLOYEE')")
				.and()
				.formLogin()
				// login configuration
				.loginPage("/").loginProcessingUrl("/Login")
				.defaultSuccessUrl("/default")
				.usernameParameter("email").passwordParameter("password").and()
				.logout().logoutUrl("/logout")
				// logout configuration
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/error").and().csrf();
	}
}