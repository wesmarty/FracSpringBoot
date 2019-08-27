package com.frac.FracAdvanced.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.frac.FracAdvanced.model.MiniFracModel;
import com.frac.FracAdvanced.model.OutputMiniFrac;

@Repository
public interface MiniFracRepo extends JpaRepository<MiniFracModel, Integer> {

	@Query("SELECT t FROM MiniFracModel t where t.details.id = :id") 
    List<MiniFracModel> findByProId(@Param("id") Integer id);
}
