package dev.michalgruszka.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResultController {

	@RequestMapping(value = "/result", method = RequestMethod.POST)
	public ModelAndView result() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		mv.addObject("shortURL", "http://www.example.com");
		
		return mv;
	}
}
