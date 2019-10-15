/**
 * 
 */
package com.frac.FracAdvanced.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frac.FracAdvanced.model.ReservoirFluidModel;
import com.frac.FracAdvanced.service.ReservoirFluidService;

/**
 * @author ShubhamGaur
 *
 */
@Controller
@RequestMapping("/reservoirFluid1")
public class ReservoirFluid1 {

	String map = "view/reservoirfluid1";
	@Autowired
	ReservoirFluidService reservoirFluid;	
	
	@RequestMapping("/showreservoir1")
	public String show1(Model model, @RequestParam("pid") Integer pid) throws Exception
	{				
	List<ReservoirFluidModel> b1=	reservoirFluid.getListMethod(pid, "Reservoir properties");		
		model.addAttribute("pid", pid);
        model.addAttribute("list", b1);
        return "/view/reservoirFluid2/showlist";		
	}
	
	@RequestMapping("/showRFSecondController")
	public String changeTypeOfFluid(@RequestParam("pid") Integer pid1,
			              @RequestParam("fluidT") String ftype,
			              Model model) throws Exception
	{
		//int pid= Integer.parseInt(pid1);
		List<ReservoirFluidModel> b1=	reservoirFluid.getListMethod(pid1,ftype);		
        model.addAttribute("pid", pid1);
        model.addAttribute("list", b1);
        return "/view/reservoirFluid2/showlist";		
   }
	
	
	@RequestMapping("/updateValueController")
	public String updateRF(@RequestParam("pid") Integer pid,		              			             
			              @RequestParam("value") List<String> value,
			              @RequestParam("ftype1") List<String> ftype,
			              Model model) throws Exception
	{
		String typeNmae=ftype.get(0);		
		List<ReservoirFluidModel> b1=reservoirFluid.methodEditValue(pid,typeNmae,value);	
		model.addAttribute("pid", pid);
		model.addAttribute("list", b1);
		return "/view/reservoirFluid2/showlist";
		
	}
	
	@RequestMapping("/updateRadioWellTypeController")
	public String updateRadioWellData(@RequestParam("pid") Integer pid,		              
			              @RequestParam("welltypeaq") String wellType,
			              RedirectAttributes redirectAttribute
			              ) throws Exception
	{
		reservoirFluid.methodEditWellType(pid, wellType);
		redirectAttribute.addFlashAttribute("pid",pid);
		return "redirect:/showreservoir1";
	}
	
	/*@RequestMapping("/showreservoir1")
	public String show1(Model model, @RequestParam("pid") Integer pid) {
		System.out.println("this is the fluid property first con");
		if(reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("oil")==null&&
				reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("gas")==null&&
				reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("water")==null) {
			model.addAttribute("pid", pid);
			return map + "/import";
		}
		else {
			model.addAttribute("list", reservoirFluid1.showImportList(pid));
			model.addAttribute("oil", reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("oil"));
			model.addAttribute("gas", reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("gas"));
			model.addAttribute("water", reservoirFluid1.showSavedData(pid,reservoirFluid1.getfluidtype(pid)).get("water"));
			model.addAttribute("pid", pid);
			model.addAttribute("type", reservoirFluid1.getfluidtype(pid));
			return map + "/showlist";
		}
	}

	@RequestMapping("/saveresfluidtype1")
	public String savereservoirfluid1(Model model, @RequestParam("pid") Integer pid,
			@RequestParam("type") String type) {
		model.addAttribute("list", reservoirFluid1.showImportList(pid));
		model.addAttribute("oil", reservoirFluid1.saveReservoirFluidtype(pid, type).get("oil"));
		model.addAttribute("gas", reservoirFluid1.saveReservoirFluidtype(pid, type).get("gas"));
		model.addAttribute("water", reservoirFluid1.saveReservoirFluidtype(pid, type).get("water"));
		model.addAttribute("pid", pid);
		model.addAttribute("type", type);
		return map + "/import";
	}

	@RequestMapping("/saveresfluidinput1")
	public String saveresfluidinput1(Model model, @RequestParam("imppid") Integer pid,
			@RequestParam("if_impinput") List<String> input,@RequestParam("imptype") String type) {
		reservoirFluid1.saveResFluidData(pid, input);
		model.addAttribute("list", reservoirFluid1.showImportList(pid));
		model.addAttribute("oil", reservoirFluid1.showSavedData(pid,type).get("oil"));
		model.addAttribute("gas", reservoirFluid1.showSavedData(pid,type).get("gas"));
		model.addAttribute("water", reservoirFluid1.showSavedData(pid,type).get("water"));
		model.addAttribute("pid", pid);
		model.addAttribute("type", type);
		return map + "/showlist";
	}
	
	@RequestMapping("/showupdate")
	public String showupdate(Model model,@RequestParam("pid") Integer pid,@RequestParam("type") String type) {
		model.addAttribute("list", reservoirFluid1.showImportList(pid));
		model.addAttribute("oil", reservoirFluid1.showSavedData(pid,type).get("oil"));
		model.addAttribute("gas", reservoirFluid1.showSavedData(pid,type).get("gas"));
		model.addAttribute("water", reservoirFluid1.showSavedData(pid,type).get("water"));
		model.addAttribute("pid", pid);
		model.addAttribute("type", type);
		return map + "/update";
	}
	
	@RequestMapping("/updateres")
	public String updateRes(Model model, @RequestParam("showpid") Integer pid,
			@RequestParam("if_upinputid") List<Integer> id,
			@RequestParam("if_upinput") List<String> input,
			@RequestParam("imptype") String type) {
		reservoirFluid1.updateResFluid(pid, id, input);
		model.addAttribute("list", reservoirFluid1.showImportList(pid));
		model.addAttribute("oil", reservoirFluid1.showSavedData(pid,type).get("oil"));
		model.addAttribute("gas", reservoirFluid1.showSavedData(pid,type).get("gas"));
		model.addAttribute("water", reservoirFluid1.showSavedData(pid,type).get("water"));
		model.addAttribute("pid", pid);
		model.addAttribute("type", type);
		return map + "/showlist";
	}*/
	
}
