/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirLithologyModel;

/**
 * @author ShubhamGaur
 *
 */
public interface ReservoirLithologyRepo extends JpaRepository<ReservoirLithologyModel, Integer> {
	List<ReservoirLithologyModel> findBydetails(ProjectDetails details);
}
