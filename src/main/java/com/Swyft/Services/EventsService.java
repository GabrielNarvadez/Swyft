package com.Swyft.Services;

import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EventsService {
    @Autowired
    private EventsRepository eventsRepository;


    public EventsDTO createEvent(EventsDTO eventRequest) {
        EventsDTO resp = new EventsDTO();
        try {
            Events events = new Events();

            events.setTitle(eventRequest.getTitle());
            events.setDate(eventRequest.getDate());
            events.setDetails(eventRequest.getDetails());
            events.setLocation(eventRequest.getLocation());

            Events eventsSaved = eventsRepository.save(events);

            if (eventsSaved.getTitle().equals(eventRequest.getTitle())) {
                resp.setEvent(eventsSaved); // Assuming you have a setter for event in EventsDTO
                resp.setMessage("Successfully Saved");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }
}


