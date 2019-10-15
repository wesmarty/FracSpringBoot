/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.frac.FracAdvanced.model.InjectedFluid1Model;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.RockPropertiesModel;

/**
 * @author ShubhamGaur
 *
 */
public interface RockPropertiesRepo extends JpaRepository<RockPropertiesModel, Integer>{

	List<RockPropertiesModel> findBydetails(ProjectDetails details);
	List<RockPropertiesModel> findByStageAndDetails(String stage,ProjectDetails details);
	
	Long countBydetails(ProjectDetails details);
}
