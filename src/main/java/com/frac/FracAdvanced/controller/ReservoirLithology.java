package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservoirLithology {
	
	@RequestMapping("/reservoirLithology")
	public String show() {
		return "view/resevoirlithology";
	}
}
