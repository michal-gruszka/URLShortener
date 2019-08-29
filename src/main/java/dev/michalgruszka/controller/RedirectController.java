package dev.michalgruszka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dev.michalgruszka.model.Url;
import dev.michalgruszka.service.UrlService;

@Controller
public class RedirectController {

	@Autowired
	UrlService urlService;
	
	@RequestMapping(value ="/{code}", method = RequestMethod.GET)
	public String redirect(@PathVariable final String code) {
		
		try {
			
			Url url = urlService.getByShortUrl(code);
			return "redirect:" + url.getOriginalUrl();

			
		} catch (Exception e) {
			// TODO: add logging
			return "error";
		}
	}
}
