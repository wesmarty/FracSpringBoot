/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.WellForcastModel;

/**
 * @author ShubhamGaur
 *
 */
public interface WellForcastRepo extends JpaRepository<WellForcastModel, Integer>{
	List<WellForcastModel> findBydetails(ProjectDetails detail);
}
