package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InjectionPlan {
	
	@RequestMapping("/injectionPlan")
	public String show() {
		return "view/injectionplan";
	}
}
