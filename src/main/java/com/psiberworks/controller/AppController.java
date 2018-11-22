package com.psiberworks.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.psiberworks.models.TaxRebateThreshold;
import com.psiberworks.models.TaxTable;
import com.psiberworks.payloads.InputPayload;
import com.psiberworks.payloads.OutputPayload;
import com.psiberworks.repository.TaxRebateThresholdRepository;
import com.psiberworks.repository.TaxTableRepository;
import com.psiberworks.service.AppService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AppController {

	private final AppService appService;
	
	@Autowired
	public AppController(AppService appService){
		this.appService = appService;
	}

	@PostMapping("/calculateTax")
	public String handlePostRequest(InputPayload inputPayload) {
		
		OutputPayload outputPayload = appService.calculateTax(inputPayload);
		//model.addAttribute("outputPayload", outputPayload);

		return "redirect:/";
	}

	@GetMapping("/")
	public String handleGetRequest(Model model) {
		

		//OutputPayload outputPayload = appService.calculateTax(requestPayload);
		InputPayload inputPayload = new InputPayload();
		model.addAttribute("inputPayload",inputPayload);

		OutputPayload outputPayload = new OutputPayload();
		model.addAttribute("outputPayload", outputPayload);

		return "home";
	}



}