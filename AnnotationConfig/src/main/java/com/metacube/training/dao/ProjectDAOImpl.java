package com.metacube.training.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.metacube.training.dao.interfaces.ProjectDAO;
import com.metacube.training.mappers.ProjectMapper;
import com.metacube.training.model.Project;

@Repository
public class ProjectDAOImpl implements ProjectDAO
{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ProjectDAOImpl(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private final String SQL_FIND_PROJECT = "SELECT * FROM project WHERE project_id = ?";
	private final String SQL_DELETE_PROJECT = "DELETE FROM project WHERE project_id = ?";
	private final String SQL_UPDATE_PROJECT = "UPDATE project SET project_name = ?, project_description = ?, start_date  = ?, end_date  = ? WHERE project_id = ?";
	private final String SQL_GET_ALL = "SELECT * FROM project";
	private final String SQL_INSERT_PROJECT = "INSERT INTO project(project_name, project_description, start_date, end_date) VALUES(?, ?, ?, ?)";

	public Project getProjectById(Long id)
	{
		return jdbcTemplate.queryForObject(SQL_FIND_PROJECT, new Object[] { id }, new ProjectMapper());
	}

	public List<Project> getAllProjects()
	{
		return jdbcTemplate.query(SQL_GET_ALL, new ProjectMapper());
	}

	public boolean deleteProject(Project person)
	{
		return jdbcTemplate.update(SQL_DELETE_PROJECT, person.getId()) > 0;
	}

	public boolean updateProject(Project person)
	{
		return jdbcTemplate.update(SQL_UPDATE_PROJECT, person.getName(), person.getDescription(), person.getStartDate(),
				person.getEndDate(), person.getId()) > 0;
	}

	public boolean createProject(Project person)
	{
		return jdbcTemplate.update(SQL_INSERT_PROJECT, person.getName(), person.getDescription(), person.getStartDate(),
				person.getEndDate()) > 0;
	}
}