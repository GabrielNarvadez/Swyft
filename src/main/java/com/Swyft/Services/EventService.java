package com.Swyft.Services;

import java.util.List;

import com.Swyft.mainClasses.Event;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class EventService {
	@GetMapping
    public List<Event> getEvent() {
        return List.of(new Event(1L, "CpeLympics", "March 23"));
    }
}
