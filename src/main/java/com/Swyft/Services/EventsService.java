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
    public EventsDTO updateEvent(EventsDTO eventRequest) {
        EventsDTO resp = new EventsDTO();
        try {
            // Retrieve the existing event from the database using the provided eventId
            Optional<Events> optionalEvents = eventsRepository.findById(eventRequest.getId());
            if (optionalEvents.isPresent()) {
                Events events = optionalEvents.get();

                // Update the fields of the existing event with the values from the request
                events.setTitle(eventRequest.getTitle());
                events.setDate(eventRequest.getDate());
                events.setDetails(eventRequest.getDetails());
                events.setLocation(eventRequest.getLocation());

                // Save the updated event
                Events eventsSaved = eventsRepository.save(events);

                // Set the updated event in the response
                resp.setEvent(eventsSaved);
                resp.setMessage("Successfully Updated");
            } else {
                resp.setStatusCode(404);
                resp.setMessage("Event not found");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
    public EventsDTO deleteEvent(int eventID) {
        EventsDTO resp = new EventsDTO();
        try {
            eventsRepository.deleteById(eventID);
            resp.setMessage("Successfully Deleted");
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
}


