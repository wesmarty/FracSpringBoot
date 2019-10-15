/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.model.WellForcastDeclinedCurveModel;

/**
 * @author ShubhamGaur
 *
 */
public interface WellForcastDeclinedCurveRepo extends JpaRepository<WellForcastDeclinedCurveModel, Integer> {
	List<WellForcastDeclinedCurveModel> findBydetails(ProjectDetails details);
}
