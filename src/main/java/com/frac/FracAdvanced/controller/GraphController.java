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

import com.frac.FracAdvanced.model.MainFracGraphModel;
import com.frac.FracAdvanced.model.OutputMiniFrac;
import com.frac.FracAdvanced.model.OutputStressModel;
import com.frac.FracAdvanced.model.WellForcastDeclinedCurveModel;
import com.frac.FracAdvanced.repository.OutputMiniFracRepo;
import com.frac.FracAdvanced.service.MainFracGraphService;
import com.frac.FracAdvanced.service.OutputStressService;
import com.frac.FracAdvanced.service.WellForcastDeclinedCurverService;

@Controller
public class GraphController {
	
	@Autowired
	private OutputMiniFracRepo output;
	@Autowired
	private OutputStressService stressservice;
	@Autowired
	private WellForcastDeclinedCurverService curveservice;
	@Autowired
	MainFracGraphService fracGraphService;  
	
	@PostMapping("/graphs")
	public String graphs(@RequestParam("p_Id") int p_id,Model model) {
		model.addAttribute("p_id", p_id);
		return "view/showgraph";
	}
	
	@RequestMapping("/showMiniGraph/{pid}")
	@ResponseBody
	public List<OutputMiniFrac> showminiGraph(@PathVariable("pid") Integer pid,@RequestParam("x[]") String[] x) {
		return output.findByProId(pid);
	}
	
	@RequestMapping("/showStressGraph/{pid}")
	@ResponseBody
	public List<OutputStressModel> showstressGraph(@PathVariable("pid") Integer pid,@RequestParam("x[]") String[] x){
		return stressservice.showList(pid);
	}
	
	@RequestMapping("/showdeclinedcurve/{pid}")
	@ResponseBody
	public List<WellForcastDeclinedCurveModel> showDeclinedCurve(@PathVariable("pid") Integer pid){
		return curveservice.showlist3(pid);
	}
	@RequestMapping("/showmainfrac/{pid}")
	@ResponseBody
	public List<MainFracGraphModel> showMainFrac(@PathVariable("pid") Integer pid){
		return fracGraphService.showmainfrac(pid);
	}
	
	@RequestMapping("/showhalflength/{pid}")
	@ResponseBody
	public String showHalfLength(@PathVariable("pid") Integer pid) {
		System.out.println("~~~  "+pid);
		return pid.toString();
	}
}
