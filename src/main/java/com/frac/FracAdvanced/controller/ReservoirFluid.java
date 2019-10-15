/**
 * 
 *//*
package com.frac.FracAdvanced.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;
import com.frac.FracAdvanced.repository.ReservoirFluidRepo;
import com.frac.FracAdvanced.service.ReservoirFluidService;

*//**
 * @author ShubhamGaur
 *
 *//*
@Controller
@RequestMapping("/reservoirFluid")
public class ReservoirFluid {

		String map="view/reservoirfluid";
		
		@Autowired
		private ReservoirFluidService fluidservice;
		@Autowired
		private ReservoirFluidRepo ReservoirFluid;
		@Autowired
		private ProjectDetailRepo detailrepo;
		
		@RequestMapping("/showreservoir")
		public String show(Model model,@RequestParam("pid") Integer pid) {
			System.out.println("this is the fluid property first con");
			if(fluidservice.findByPId(pid).get(fluidservice.findByPId(pid).size()-1).getFluidtype().equalsIgnoreCase("N/A")) {
			model.addAttribute("pid", pid);
			return map+"/import";
			}
			else {
				model.addAttribute("list", fluidservice.findByPId(pid));
				model.addAttribute("pid", pid);
				return map+"/showlist";
			}
		}
		
		@RequestMapping("/showfluidtype")
		public String showFluidType(Model model,@RequestParam("pid") Integer pid,@RequestParam("fluid") String fluidtype) {
			model.addAttribute("pid", pid);
			model.addAttribute("list", fluidservice.fluidType(pid, fluidtype));
			model.addAttribute("fluidtype", fluidtype);
			return map+"/import";
		}
		
		@RequestMapping("/savereservoir")
		public String saveReservoir(Model model,@RequestParam("imppid") Integer pid,@RequestParam("impfluidtype") String fluidtype,
				@RequestParam("rf_impparam") List<String> param,
				@RequestParam("rf_impvalue") List<String> value) {
			ProjectDetails details=detailrepo.findById(pid).orElse(null);
			fluidservice.saveReservoirFluid(pid, param, value, fluidtype);
			model.addAttribute("list", ReservoirFluid.findByFluidtypeAndDetails(fluidtype, details));
			return map+"/showlist";
		}
}
*/