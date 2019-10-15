/**
 * 
 */
package com.frac.FracAdvanced.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frac.FracAdvanced.model.OutputWellforcastModel;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.OutputWellForcastRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

/**
 * @author ShubhamGaur
 *
 */
@Service
public class OutputWellForcastService {

	@Autowired
	private OutputWellForcastRepo outforcastRepo;
	@Autowired
	private ProjectDetailRepo detailRepo;
	
	public void saveOutforcast(Integer pid,Map<String,Double> map) {
		ProjectDetails detail = detailRepo.findById(pid).orElse(null);
		List<OutputWellforcastModel> list=new ArrayList<OutputWellforcastModel>(); 
		for (Map.Entry<String, Double> entry : map.entrySet()) {
			OutputWellforcastModel model =new OutputWellforcastModel();
			model.setDetails(detail);
			model.setParam(entry.getKey());
			model.setValue(String.valueOf(map.get(entry.getKey())));
		    list.add(model);
		}
		outforcastRepo.saveAll(list);
	}
	
	public List<OutputWellforcastModel> showList(Integer pid){
		ProjectDetails detail = detailRepo.findById(pid).orElse(null);
		List<OutputWellforcastModel> list=outforcastRepo.findBydetails(detail);
		return list;
	}
}
