package com.metacube.training.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder authenticate) throws Exception {
		authenticate.inMemoryAuthentication().withUser("admin@gmail.com").password("{noop}1234").roles("ADMIN");
		authenticate.inMemoryAuthentication().withUser("emp@gmail.com").password("{noop}1234").roles("EMPLOYEE");
		authenticate.inMemoryAuthentication().withUser("emp2@gmail.com").password("{noop}1234").roles("EMPLOYEE");
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
				.loginPage("/login").loginProcessingUrl("/Login")
				.defaultSuccessUrl("/default")
				.usernameParameter("email").passwordParameter("password").and()
				.logout().logoutUrl("/logout")
				// logout configuration
				.logoutSuccessUrl("/login").and().exceptionHandling()
				.accessDeniedPage("/error").and().csrf();
	}
}