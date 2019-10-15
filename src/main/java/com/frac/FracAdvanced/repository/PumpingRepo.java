/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.PumpingModel;

/**
 * @author ShubhamGaur
 *
 */
public interface PumpingRepo extends JpaRepository<PumpingModel, Integer> {

	List<PumpingModel> findBydetails(ProjectDetails details);
	
	
}
