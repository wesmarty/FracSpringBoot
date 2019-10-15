package com.frac.FracAdvanced.repository;

import java.awt.FlowLayout;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.frac.FracAdvanced.model.FluidLibraryModel;


public interface FluidLibraryRepo extends JpaRepository<FluidLibraryModel, Integer>{

	@Query("SELECT t FROM FluidLibraryModel t where t.pidFL.id = :id") 
    List<FluidLibraryModel> findByProId(@Param("id") Integer id);

}
