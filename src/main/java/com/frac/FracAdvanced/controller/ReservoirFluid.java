package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReservoirFluid {
	
	@RequestMapping("/reservoirFluid")
	public String show() {
		return "view/reservoirfluid";
	}
}
