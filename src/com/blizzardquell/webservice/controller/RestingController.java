package com.blizzardquell.webservice.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/service/events")
public class RestingController {
	@RequestMapping(value = "/{accessToken}", method = RequestMethod.GET)
	public String getEvents(@PathVariable String accessToken) {
		String result = "Hello " + accessToken;
		return result;
	}
}