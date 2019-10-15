/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.StressAnalysisModel;

/**
 * @author ShubhamGaur
 *
 */
public interface StressAnalysisRepo extends JpaRepository<StressAnalysisModel, Integer> {
	List<StressAnalysisModel> findBydetails(ProjectDetails detail);
}
