package com.frac.FracAdvanced.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

@Controller
public class Application {
	
	@Autowired
	ProjectDetailRepo repo;
	
	@RequestMapping("/")
	public String index(Model model) {
		
		//List list=repo.findAll();
		model.addAttribute("list", repo.findAll());
		//System.out.println(list);
		return "projectDetails/list";    /*here list.html*/
	}
	@RequestMapping("/create")
	public String create() {
		return "projectDetails/create";
	}
	@RequestMapping("/showDetail")
	public String showProject(Model model) {
		ProjectDetails detail=new ProjectDetails();
		model.addAttribute("ProjectDetail", detail);
		return "projectDetails/projectDetail";
	}
	
	@RequestMapping("/detail")
	public String saveProject(Model model,@RequestParam Map<String,String> requestparams, RedirectAttributes attributes)throws Exception {
		String projectname=requestparams.get("projectName");
		String wellname=requestparams.get("wellName");
		String compname=requestparams.get("companyName");
		String date = new Date().toString();
		
		ProjectDetails detail=new ProjectDetails();
		detail.setProjectName(projectname);
		detail.setWellName(wellname);
		detail.setCompanyName(compname);
		detail.setDateCreated(date);
		repo.save(detail);
		
		attributes.addFlashAttribute("ProjectDetail", detail);
		return "redirect:/list"; /* here list is controller */
	}
}