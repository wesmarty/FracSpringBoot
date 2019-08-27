package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AcidType {
	
	@RequestMapping("/acidType")
	public String show() {
		return "view/acidtype";
	}
}
