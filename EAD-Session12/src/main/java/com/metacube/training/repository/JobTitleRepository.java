package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.metacube.training.model.JobTitle;

/**
 * the class defines repository class for job title
 */
public interface JobTitleRepository<T> extends JpaRepository<JobTitle, Integer>
{
	public List<JobTitle> getAllJobTitle();
	
}
