package com.blizzardquell.business;

import java.util.ArrayList;

import org.springframework.social.*;
import org.springframework.social.facebook.api.CoverPhoto;
import org.springframework.social.facebook.api.Event;
import org.springframework.social.facebook.api.EventOperations;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.LikeOperations;
import org.springframework.social.facebook.api.Page;
import org.springframework.social.facebook.api.PagedList;
import org.springframework.social.facebook.api.impl.FacebookTemplate;

import com.blizzardquell.model.EventObj;

public class EventRecommendation {

	private String accessToken;
	private Facebook facebook;
	private EventOperations eventOperations;
	private LikeOperations likeOperations;

	public EventRecommendation(String accessToken) {
		this.accessToken = accessToken;
		facebook = new FacebookTemplate(accessToken);
		likeOperations = facebook.likeOperations();
		eventOperations = facebook.eventOperations();
	}

	private PagedList<Page> GetUserLikes() {
		PagedList<Page> pages = likeOperations.getPagesLiked();
		return pages;
	}

	private ArrayList<Event> GetEvents(PagedList<Page> pages) {
		ArrayList<Event> allEvents = new ArrayList<Event>();
		for (Page page : pages) {
			PagedList<Event> events = eventOperations.search(page.getCategory());
			allEvents.addAll(events);
		}
		return allEvents;
	}

	public ArrayList<EventObj> GetEvents() {
		PagedList<Page> pages = GetUserLikes();
		ArrayList<Event> events = GetEvents(pages);

		ArrayList<EventObj> eventObjs = new ArrayList<EventObj>(events.size());
		for (Event event : events) {

			EventObj eo = new EventObj();
			CoverPhoto p = event.getCover();
			if(p != null){
				eo.setUrl(p.getSource());
			}
			eo.setDesc(event.getDescription());
			eo.setStartTime(event.getStartTime());
			eo.setEndTime(event.getEndTime());
			eo.setId(event.getId());
			eo.setName(event.getName());

			eventObjs.add(eo);
		}

		return eventObjs;
	}

}
