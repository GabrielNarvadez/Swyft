package com.Swyft.Services;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
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
            events.setDate_posted(LocalDate.now());
            events.setAttendee_count(0);
            events.setTitle(eventRequest.getTitle());
            events.setDate(eventRequest.getDate());
            events.setDetails(eventRequest.getDetails());
            events.setLocation(eventRequest.getLocation());
            events.setRng();

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
            Optional<Events> optionalEvents = eventsRepository.findById(eventRequest.getEvent_Id());
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

    public EventsDTO deleteEvent(EventsDTO eventsRequest) {
        EventsDTO resp = new EventsDTO();
        try {
            Integer eventID = eventsRequest.getEvent_Id();
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
        dto.setEvent_id(event.getEvent_id());
        dto.setTitle(event.getTitle());
        dto.setDate(event.getDate());
        dto.setDetails(event.getDetails());
        dto.setLocation(event.getLocation());
        dto.setDate_posted(event.getDate_posted());
//
//        // Calculate days ago count
//        LocalDate currentDate = LocalDate.now();
//        Period period = Period.between(event.getDate_posted(), currentDate);
//        dto.setDaysAgo(period.getDays());

        return dto;
    }
}
//    public static Integer calculateDaysAgo(LocalDate date_posted) {
//        LocalDate currentDate = LocalDate.now();
//        EventsDTO eventsDTO = new EventsDTO();
//        Period period = Period.between(date_posted, currentDate);
//
//        int days = period.getDays();
//
//        if (days > 0) {
//            return new EventsDTO(days);
//        } else {
//            return new EventsDTO(0);
//        }
//    }
//}
