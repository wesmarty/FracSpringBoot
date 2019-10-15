package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.InjectedFluidModel;
import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface InjectedFluidRepo extends JpaRepository<InjectedFluidModel, Integer> {

		List<InjectedFluidModel> findBydetails(ProjectDetails details);
}
