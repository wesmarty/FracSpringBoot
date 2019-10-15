package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.frac.FracAdvanced.model.MainFracGraphModel;
import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface MainFracGraphRepo extends CrudRepository<MainFracGraphModel, Integer>{
	List<MainFracGraphModel> findBydetails(ProjectDetails details);
}
