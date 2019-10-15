/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.ReservoirFluidModel;

/**
 * @author ShubhamGaur
 *
 */
public interface ReservoirFluidRepo extends JpaRepository<ReservoirFluidModel, Integer> {

		List<ReservoirFluidModel> findBydetails(ProjectDetails details);
		List<ReservoirFluidModel> findByFluidtypeAndDetails(String fluidtype,ProjectDetails details);
}
