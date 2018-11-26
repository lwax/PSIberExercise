package com.psiberworks.controller;


import com.psiberworks.payloads.InputPayload;
import com.psiberworks.payloads.OutputPayload;
import com.psiberworks.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AppController {

	private final AppService appService;
	
	@Autowired
	public AppController(AppService appService){
		this.appService = appService;
	}

	@PostMapping("/calculate")
	public String handlePostRequest(@ModelAttribute InputPayload inputPayload, Model model, RedirectAttributes ra) {
		
		OutputPayload outputPayload = appService.calculateTax(inputPayload);
		//model.addAttribute("outputPayload", outputPayload);
		ra.addFlashAttribute(outputPayload);
		return "redirect:/";
	}

	@GetMapping("/")
	public String handleGetRequest(Model model, @ModelAttribute("outputPayload") OutputPayload outputPayload) {
		

		//OutputPayload outputPayload = appService.calculateTax(requestPayload);
		InputPayload inputPayload = new InputPayload();
		model.addAttribute("inputPayload",inputPayload);
		model.addAttribute("outputPayload", outputPayload);

		return "home";
	}



}