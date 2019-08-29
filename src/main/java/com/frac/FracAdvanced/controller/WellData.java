package com.frac.FracAdvanced.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WellData {

		@RequestMapping("/wellData")
		public String show() {
			
			return "view/welldata";
		}
}
