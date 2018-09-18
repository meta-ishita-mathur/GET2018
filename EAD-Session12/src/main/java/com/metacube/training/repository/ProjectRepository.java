package com.metacube.training.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.metacube.training.model.Project;

/**
 * the class defines repository class for project
 */
public interface ProjectRepository<P> extends JpaRepository<Project, Integer>
{	

}
