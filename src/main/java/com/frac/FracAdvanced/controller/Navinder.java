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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.frac.FracAdvanced.Method.WriteReadFile;
import com.frac.FracAdvanced.model.MiniFracModel;
import com.frac.FracAdvanced.model.ProjectDetails;
import org.springframework.beans.factory.annotation.Autowired;

import com.frac.FracAdvanced.repository.MiniFracRepo;
import com.frac.FracAdvanced.repository.ProjectDetailRepo;

/**
 * @author ShubhamGaur
 *
 */
@Controller
//@RequestMapping(value = "navinder")
@SessionAttributes(value = {"ProjectDetail"})
public class Navinder {
	
	@Autowired
	MiniFracRepo service;
	
	@Autowired
	ProjectDetailRepo prodetails;
	
	@RequestMapping("/list")
	public String show(@ModelAttribute("ProjectDetail") ProjectDetails details,HttpSession session){
		session.setAttribute("ProjectDetail", details);
		return "projectDetails/projectDetail";
	}
}
