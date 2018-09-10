package com.metacube.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.metacube.training.connection.Connect;
import com.metacube.training.dao.interfaces.SkillDAO;
import com.metacube.training.model.Skill;

@Repository 
public class SkillDAOImpl implements SkillDAO
{
	private final String GET_ALL_Skill_Query = "select * from skill_master";
	private final String INSERT_QUERY = "INSERT INTO skill_master(skill_name) VALUES (?)";

	public List<Skill> getAllSkills()
	{
		List<Skill> resultList = new ArrayList<Skill>();
		try
		(
			Connection connect = Connect.getConnection();
			PreparedStatement statement =  connect.prepareStatement(GET_ALL_Skill_Query);
		){
			ResultSet result = statement.executeQuery();
			while(result.next())
			{
				int id = result.getInt("skill_id");
				String title = result.getString("skill_name");
				Skill newSkill = new Skill();
				newSkill.setId(id);
				newSkill.setName(title);
				resultList.add(newSkill);
			}
		}
		catch(SQLException error)
		{
			error.printStackTrace();
		}	
		return resultList;
	}

	public boolean createSkill(Skill skill)
	{
		boolean created = false;
		try
		(
			Connection connect = Connect.getConnection();
			PreparedStatement statement =  connect.prepareStatement(INSERT_QUERY);
		){
			statement.setString(1, skill.getName());
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