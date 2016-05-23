package com.blizzardquell.model;

import java.util.Date;

import org.springframework.social.facebook.api.Place;

public class EventObj {

	private String url;
	private String description;
	private Date startTime;
	private Date endTime;
	private String id;
	private String name;

	public void setUrl(String source) {
		this.url = source;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getUrl() {
		return url;
	}

	public String getDesc() {
		return description;
	}

	public Date getStartTime() {
		return startTime;
	}

	public Date setEndTime() {
		return endTime;
	}

	public String setId() {
		return id;
	}

	public String setName() {
		return name;
	}
	
	
}
