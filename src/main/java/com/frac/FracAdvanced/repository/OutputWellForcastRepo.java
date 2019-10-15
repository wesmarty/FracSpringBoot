/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frac.FracAdvanced.model.OutputWellforcastModel;
import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface OutputWellForcastRepo extends JpaRepository<OutputWellforcastModel, Integer>{
	List<OutputWellforcastModel> findBydetails(ProjectDetails detail);
}
