package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Application {
	@RequestMapping("/")
	public String index() {
		return "projectDetails/create";
	}
	
	@RequestMapping("/log")
	public String log() {
		return "log";
	}
}
