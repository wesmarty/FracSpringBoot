/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.OutputStressModel;
import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface OutputStressRepo extends JpaRepository<OutputStressModel, Integer> {
	List<OutputStressModel> findBydetails(ProjectDetails details);
}
