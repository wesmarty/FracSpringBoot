package com.frac.FracAdvanced.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.frac.FracAdvanced.model.OutputMiniFrac;
import com.frac.FracAdvanced.repository.OutputMiniFracRepo;

@Controller
public class GraphController {
	
	@Autowired
	private OutputMiniFracRepo output;
	
	@PostMapping("/graphs")
	public String graphs(@RequestParam("p_Id") int p_id,Model model) {
		model.addAttribute("p_id", p_id);
		return "view/showgraph";
	}
	
	@RequestMapping("/showGraph/{id}")
	@ResponseBody
	public List<OutputMiniFrac> showGraph(@PathVariable("id") Integer id,@RequestParam("x[]") String[] x) {
		System.out.println("ARRAY LENGTH: "+x.length);
		List<OutputMiniFrac> charts=output.findByProId(id);
		System.out.println("CHART LIST: "+charts);
		return charts;
	}
}
