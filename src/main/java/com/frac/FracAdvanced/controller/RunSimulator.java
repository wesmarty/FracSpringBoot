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

import com.frac.FracAdvanced.Method.MiniFracAlgo;
import com.frac.FracAdvanced.Method.WriteReadFile;
import com.frac.FracAdvanced.model.OutputMiniFrac;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.OutputMiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

@RestController
public class RunSimulator {

		@Autowired
		private OutputMiniFracRepo output;
		@Autowired
		private ProjectDetailRepo details;
		@Autowired
		OutputMiniFracRepo outrepo;
	
	@GetMapping("/dede")
	public List<OutputMiniFrac> createOutput(Model model) {
		List<OutputMiniFrac> list = output.findAll();
		model.addAttribute("list", list);
		return list;
	}
	
	@RequestMapping("/simulate")
	@ResponseBody
	public String simulate(@RequestParam("pId") int p_id,RedirectAttributes attributes) throws Exception {
		WriteReadFile.createInputFile();
		Map<String, String> inputfilemap=WriteReadFile.readInputFile();
		MiniFracAlgo.calculate(inputfilemap,p_id);
		return "Success";
	}
	
}
