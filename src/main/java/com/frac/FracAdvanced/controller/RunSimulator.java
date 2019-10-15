package com.frac.FracAdvanced.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frac.FracAdvanced.Method.MainFracGraph;
import com.frac.FracAdvanced.Method.MiniFracAlgo;
import com.frac.FracAdvanced.Method.StressAnalysisAlgo;
import com.frac.FracAdvanced.Method.WriteReadFile;
import com.frac.FracAdvanced.model.OutputMiniFrac;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.OutputMiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

/**
 * @author ShubhamGaur
 *
 */
@RestController
public class RunSimulator {

		@Autowired
		private OutputMiniFracRepo output;
		@Autowired
		private ProjectDetailRepo details;
		@Autowired
		OutputMiniFracRepo outrepo;
		@Autowired
		MainFracGraph maingraph;
	
	
	@RequestMapping("/simulate")
	@ResponseBody
	public String simulate(@RequestParam("pId") Integer pid,RedirectAttributes attributes) throws Exception {
		if(!output.findByProId(pid).isEmpty()) {
		output.deleteByProId(pid);}
		maingraph.SaveMainFrac(pid);
		WriteReadFile.createStressInputFile(pid);
		MiniFracAlgo.calculate(WriteReadFile.readInputFile("minifrac"),pid);
		StressAnalysisAlgo.calculate(WriteReadFile.readInputFile("stressanalysis"),pid);
		return "Success";
	}
	
}
