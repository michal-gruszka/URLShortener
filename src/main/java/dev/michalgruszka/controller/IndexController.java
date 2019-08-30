package dev.michalgruszka.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dev.michalgruszka.model.Url;
import dev.michalgruszka.service.UrlService;

@Controller
public class IndexController {

	@Autowired
	UrlService urlService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("index", "url", new Url());
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String result(@Valid @ModelAttribute("url") Url url,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {			
			return "index";
		}
		
		String shortUrl = urlService.getShortUrlFor(url.getOriginalUrl());
		if(shortUrl == null) {
			return "error";
		}
		model.addAttribute("shortUrl", shortUrl);
		
		return "result";
	}
}
