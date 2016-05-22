package com.blizzardquell.webservice.controller;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blizzardquell.business.EventRecommendation;
import com.blizzardquell.model.EventObj;

@RestController
@RequestMapping("/service/events")
public class RestingController {
	@RequestMapping(value = "/{accessToken}", method = RequestMethod.GET)
	public String getEvents(@PathVariable String accessToken) {
		EventRecommendation eventRecommendation = new EventRecommendation(accessToken);
		ArrayList<EventObj> events = eventRecommendation.GetEvents();
		
		return null;
	}
}