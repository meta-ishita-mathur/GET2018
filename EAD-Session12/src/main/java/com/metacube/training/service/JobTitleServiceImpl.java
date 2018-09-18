package com.metacube.training.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.metacube.training.model.JobTitle;
import com.metacube.training.repository.JobTitleRepository;
import com.metacube.training.service.interfaces.JobTitleService;

@Service
public class JobTitleServiceImpl implements JobTitleService
{
	@Autowired
	private JobTitleRepository<JobTitle> jobTitleRepository;

	public List<JobTitle> getAllJobTitle()
	{
		return jobTitleRepository.findAll();
	}

	public boolean deleteJobTitle(int id)
	{
		return jobTitleRepository.delete(id);
	}

	public boolean updateJobTitle(JobTitle jobTitle)
	{
		return jobTitleRepository.save(jobTitle);
	}

	public boolean createJobTitle(JobTitle jobTitle)
	{
		return jobTitleRepository.save(jobTitle);
	}

	public JobTitle getJobTitleById(int id)
	{
		return jobTitleRepository.findOne(id);
	}
}
