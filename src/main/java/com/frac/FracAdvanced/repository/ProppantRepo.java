/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ProppantModel;

/**
 * @author ShubhamGaur
 *
 */
public interface ProppantRepo extends JpaRepository<ProppantModel, Integer>{

		List<ProppantModel> findBydetails(ProjectDetails detail);
		
		@Transactional
		void deleteBydetails(ProjectDetails detail);
}
