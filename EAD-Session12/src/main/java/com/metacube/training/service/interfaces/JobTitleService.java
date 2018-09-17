package com.metacube.training.service.interfaces;

import java.util.List;
import com.metacube.training.model.JobTitle;

public interface JobTitleService
{
	public List<JobTitle> getAllJobTitle();

	public boolean deleteJobTitle(int id);

	public boolean updateJobTitle(JobTitle jobTitle);

	public boolean createJobTitle(JobTitle jobTitle);
	
	public JobTitle getJobTitleById(int id);
}