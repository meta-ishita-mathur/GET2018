package com.metacube.training.dao.interfaces;

import java.util.List;
import com.metacube.training.model.Project;

public interface ProjectDAO
{	
	public Project getProjectById(int id);

	public List<Project> getAllProjects();

	public boolean deleteProject(Project project);

	public boolean updateProject(Project project);

	public boolean createProject(Project project);
}