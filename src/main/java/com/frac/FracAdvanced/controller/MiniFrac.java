package com.frac.FracAdvanced.controller;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.frac.FracAdvanced.Method.InputFile;
import com.frac.FracAdvanced.Method.MiniFracAlgo;
import com.frac.FracAdvanced.Method.WriteReadFile;
import com.frac.FracAdvanced.model.MiniFracModel;
import com.frac.FracAdvanced.model.ProjectDetails;
import com.frac.FracAdvanced.repository.MiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

@Controller
public class MiniFrac {
	
	//public static String uploadDirectory="C://uploads";
	@Autowired
	private MiniFracRepo service;
	
	@Autowired
	private ProjectDetailRepo prodetails;
	
	@RequestMapping("/miniFrac")
	public String Show(Model model,ModelMap map, @RequestParam("pro_Id") int id,HttpSession session) {
		List<MiniFracModel> list=service.findByProId(id);
		System.out.println(list);
		if(list.isEmpty()!=true) {
		MiniFracModel pumptime=list.get(1);
		model.addAttribute("pumptime", pumptime.getPumptime());}
		else {
			model.addAttribute("pumptime", null);
		}
		model.addAttribute("hiddenId", id);
		model.addAttribute("list", list);
		
		return "view/minifrac";
	}
	
	@PostMapping("/upload")
	//@ResponseBody
	public String upload(Model model,@RequestParam("files") MultipartFile[] files){
			
		
			StringBuilder fileNames=new StringBuilder();
			String[] lines;
			LinkedHashMap<String, String> map= new LinkedHashMap<>();
			String key,value;
			int index;
			for(MultipartFile file:files) {
				//Path fileNameAndPath=Paths.get(uploadDirectory, file.getOriginalFilename());
				fileNames.append(file.getOriginalFilename());
				try {
					//Files.write(fileNameAndPath, file.getBytes());
					lines = new String(file.getBytes()).split("\n");
					
					for (String string : lines) {
						if(!string.startsWith("/")) {
							index = string.indexOf("=");
							 key = string.substring(0, index);
				             value = string.substring(index + 1);
				             map.put(key,value);
						}
					}
				model.addAttribute("msg", "successfully added  "+fileNames.toString());
				}catch (Exception e) {
					model.addAttribute("msg", "Select A file  "+fileNames.toString());
					e.printStackTrace();
				}
			}
			return "view/minifrac";
	}
	
	@PostMapping("/test2")
	@ResponseBody
	public List<MiniFracModel> test2(Model model,@RequestParam("files") MultipartFile file,@RequestParam("pumptime") Double pumptime,@RequestParam("pro_Id") int p_id, HttpSession  session )throws Exception {
		List<MiniFracModel> minifracList = InputFile.process(file,pumptime,p_id);
		return minifracList;
	}
	
	@RequestMapping("/simulate")
	public String simulate(@RequestParam("pro_Id") int p_id) throws Exception {
		WriteReadFile.CreateInputFile();
		Map<String, String> inputfilemap=WriteReadFile.readInputFile();
		MiniFracAlgo.calculate(inputfilemap,p_id);
		
		return "view/showGraph";
	}
		
}
