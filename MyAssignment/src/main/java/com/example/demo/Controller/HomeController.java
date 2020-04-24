package com.example.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.Model.Calculate;
import com.example.demo.Model.Input;

@Controller
public class HomeController {
	@RequestMapping("")																																																						
	public String home() {
		
		return "InputPage";		
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public String getData(Input input) {
		//ModelAndView mv=new ModelAndView();																								
		Calculate c=new Calculate(input);																																																																																																																																																																																																													
		String ans=c.cal();
		
		return "The minumum cost for the given data is:"+ans;
	}
}
