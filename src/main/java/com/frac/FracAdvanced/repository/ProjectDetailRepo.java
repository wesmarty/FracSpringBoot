package com.frac.FracAdvanced.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frac.FracAdvanced.model.ProjectDetails;

/**
 * @author ShubhamGaur
 *
 */
public interface ProjectDetailRepo extends JpaRepository<ProjectDetails, Integer> {

}
