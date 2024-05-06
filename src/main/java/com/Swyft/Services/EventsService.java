package com.Swyft.Services;

import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
                resp.setEvent(eventsSaved);
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
            Optional<Events> optionalEvents = eventsRepository.findById(eventRequest.getId());
            if (optionalEvents.isPresent()) {
                Events events = optionalEvents.get();

                events.setTitle(eventRequest.getTitle());
                events.setDate(eventRequest.getDate());
                events.setDetails(eventRequest.getDetails());
                events.setLocation(eventRequest.getLocation());

                Events eventsSaved = eventsRepository.save(events);

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

    public List<EventsDTO> findAllEvents() {
        return eventsRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EventsDTO convertToDTO(Events event) {
        EventsDTO dto = new EventsDTO();
        dto.setId(event.getId());
        dto.setTitle(event.getTitle());
        dto.setDate(event.getDate());
        dto.setDetails(event.getDetails());
        dto.setLocation(event.getLocation());
        // Add other fields if necessary
        return dto;
    }
}
