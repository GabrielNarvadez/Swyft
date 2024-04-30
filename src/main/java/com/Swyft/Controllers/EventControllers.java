package com.Swyft.Controllers;

import java.util.List;

import com.Swyft.mainClasses.Event;
import com.Swyft.Services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(path = "api/v1/Event")


public class EventControllers {
	
	private final EventService eventService;
	@Autowired
	public EventControllers(EventService eventService) {
		this.eventService = eventService;
	}

	@GetMapping
    public List<Event> getEvent() {
        return eventService.getEvent();
    }

}
