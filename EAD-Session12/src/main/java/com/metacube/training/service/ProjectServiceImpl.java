package com.metacube.training.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metacube.training.model.Project;
import com.metacube.training.repository.ProjectRepository;
import com.metacube.training.service.interfaces.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService
{
	@Autowired
	private ProjectRepository<Project> projectRepository;

	public Project getProjectById(int id)
	{
		return projectRepository.findOne(id);
	}

	public List<Project> getAllProjects()
	{
		return projectRepository.getAllProjects();
	}
	
	public boolean deleteProject(int id)
	{
		return projectRepository.delete(id);
	}
	
	public boolean updateProject(Project project)
	{
		return projectRepository.save(project);
	}

	public boolean createProject(Project project)
	{
		return projectRepository.save(project);
	}
}
