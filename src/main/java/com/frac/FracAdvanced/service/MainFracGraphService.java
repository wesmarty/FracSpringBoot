package com.frac.FracAdvanced.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frac.FracAdvanced.model.MainFracGraphModel;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.MainFracGraphRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

/**
 * @author ShubhamGaur
 *
 */
@Service
public class MainFracGraphService {
	
	@Autowired
	MainFracGraphRepo fracGraphRepo;
	@Autowired
	ProjectDetailRepo detailRepo;
	
	public void saveFracGraph(Integer pid,List<String> valuesX,List<String> valuesY) {
		ProjectDetails detail = detailRepo.findById(pid).orElse(null);
		List<MainFracGraphModel> list=new ArrayList<>();
		for(int i=0;i<valuesX.size();i++) {
			MainFracGraphModel model=new MainFracGraphModel();
			model.setX(valuesX.get(i));
			model.setY(valuesY.get(i));
			model.setDetails(detail);
			list.add(model);
		}
		fracGraphRepo.saveAll(list);
	}
	
	public List<MainFracGraphModel> showmainfrac(Integer pid){
		ProjectDetails detail = detailRepo.findById(pid).orElse(null);
		return fracGraphRepo.findBydetails(detail);
	}
}
