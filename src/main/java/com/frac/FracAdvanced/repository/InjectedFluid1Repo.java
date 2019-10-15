/**
 * 
 */
package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.InjectedFluid1Model;
import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface InjectedFluid1Repo extends JpaRepository<InjectedFluid1Model, Integer> {

	List<InjectedFluid1Model> findBydetails(ProjectDetails details);
}
