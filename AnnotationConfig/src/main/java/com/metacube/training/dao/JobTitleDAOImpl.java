package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.metacube.training.connection.Connect;
import com.metacube.training.dao.interfaces.JobTitleDAO;
import com.metacube.training.model.JobTitle;

@Repository
public class JobTitleDAOImpl implements JobTitleDAO
{
	private final String SQL_GET_ALL = "select * from job_title_master";
	private final String SQL_INSERT_JOB_TITLE = "insert into job_title_master(job_title) values(?)";

	public JobTitle getJobTitleById(int id)
	{
		return null;
	}

	public List<JobTitle> getAllJobTitle()
	{
		List<JobTitle> resultList = new ArrayList<JobTitle>();

		try
		(
			Connection connect = Connect.getConnection();
			PreparedStatement statement =  connect.prepareStatement(SQL_GET_ALL);
		){
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				int id = result.getInt("job_id");
				String title = result.getString("job_title");
				JobTitle newJob = new JobTitle();
				newJob.setId(id);;
				newJob.setJobTitle(title);
				resultList.add(newJob);
			}
		}
		catch(SQLException error)
		{
			error.printStackTrace();
		}	
		return resultList;
	}

	public boolean deleteJobTitle(int id)
	{
		return false;
	}

	public boolean updateJobTitle(JobTitle jobTitle)
	{
		return false;
	}

	public boolean createJobTitle(JobTitle jobTitle)
	{
		boolean created = false;
		
		try
		(
			Connection connect = Connect.getConnection();
			PreparedStatement statement =  connect.prepareStatement(SQL_INSERT_JOB_TITLE);
		){
			statement.setString(1, jobTitle.getJobTitle());
			statement.executeUpdate();
			created = true;
		}
		catch(SQLException error)
		{
			created = false;
		}	
		return created;
	}
}