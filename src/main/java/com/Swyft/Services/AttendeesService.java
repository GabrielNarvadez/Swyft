package com.Swyft.Services;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Entity.Attendees;
import com.Swyft.Entity.Events;
import com.Swyft.Repositories.AttendeesRepository;
import com.Swyft.Repositories.EventsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class AttendeesService {
    @Autowired
    private AttendeesRepository attendeesRepository;
    @Autowired
    private EventsRepository eventsRepository;

    public AttendeesDTO createAttendees(AttendeesDTO attendeesRequest, int event_id) {
        AttendeesDTO resp = new AttendeesDTO();

        try {
            Attendees attendees = new Attendees();
            attendees.setFullname(attendeesRequest.getFullname());
            attendees.setEmail(attendeesRequest.getEmail());
            attendees.setPhone(attendeesRequest.getPhone());
            attendees.setUser_message(attendeesRequest.getUser_message());
            attendees.setEvent_id(attendeesRequest.getEvent_id());

            Attendees attendeesSaved = attendeesRepository.save(attendees);

            if (attendeesSaved != null) {
                Optional<Events> eventOptional = eventsRepository.findById(event_id);
                if (eventOptional.isPresent()) {
                    Events event = eventOptional.get();
                    event.setAttendee_count(event.getAttendee_count() + 1);
                    eventsRepository.save(event);  // Save the updated event

                    resp.setAttendees(attendeesSaved);
                    resp.setMessage("Successfully Saved Attendee and Updated Event Attendee Count");
                } else {
                    resp.setMessage("Event not found");
                    resp.setStatusCode(404);
                }
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

        public AttendeesDTO deleteAttendees(AttendeesDTO attendeesRequest, EventsDTO eventsRequest, Integer attendees_id, Integer eventId) {
            AttendeesDTO resp = new AttendeesDTO();
            try {
                Attendees attendees = new Attendees();
                Events events = new Events();
                attendees.setAttendees_id(attendeesRequest.getAttendees_id());
                events.setId(eventsRequest.getEvent_Id());

                // Ensure both attendees_id and eventId are not null
                if (attendees_id == null || eventId == null) {
                    resp.setStatusCode(400);
                    resp.setMessage("Attendee ID and Event ID cannot be null");
                    return resp;
                }

                // Check if the attendee exists
                Optional<Attendees> attendeeOptional = attendeesRepository.findById(attendees_id);
                if (attendeeOptional.isPresent()) {
                    // Deleting the attendee
                    attendeesRepository.deleteById(attendees_id);
                    resp.setMessage("Successfully Deleted Attendee");

                    // Update the event attendee count
                    Optional<Events> eventOptional = eventsRepository.findById(eventId);
                    if (eventOptional.isPresent()) {
                        Events event = eventOptional.get();
                        int newAttendeeCount = event.getAttendee_count() - 1;
                        event.setAttendee_count(newAttendeeCount);
                        eventsRepository.save(event);
                    } else {
                        // Event not found
                        resp.setMessage("Event not found");
                        resp.setStatusCode(404);
                        return resp;
                    }

                    // Set success response
                    resp.setMessage("Successfully Deleted Attendee");
                } else {
                    // Attendee not found
                    resp.setMessage("Attendee not found");
                    resp.setStatusCode(404);
                }
            } catch (Exception e) {
                // Handle exceptions
                resp.setStatusCode(500);
                resp.setError(e.getMessage());
            }
            return resp;
        }
    @Service
    public class AttendanceService {

        @Autowired
        private AttendeesRepository attendeesRepository; // Assuming you have an AttendeesRepository

        public AttendeesDTO markAttendance(int attendees_id, AttendeesDTO attendeesDTO) {
            // Fetch the existing attendee details from the database
            Optional<Attendees> existingAttendeeOptional = attendeesRepository.findById(attendees_id);
            if (!existingAttendeeOptional.isPresent()) {
                // Handle case where attendee is not found
                throw new EntityNotFoundException("Attendee not found with ID: " + attendees_id);
            }
            Attendees existingAttendee = existingAttendeeOptional.get();

            // Update only the attendance status
            existingAttendee.setHas_attended(true);

            // Save the updated attendee to the database
            Attendees updatedAttendee = attendeesRepository.save(existingAttendee);

            // Convert the updated entity back to DTO and return
            return convertToDTO(updatedAttendee);
        }

        // Method to convert Attendees entity to AttendeesDTO
        private AttendeesDTO convertToDTO(Attendees attendees) {
            AttendeesDTO attendeesDTO = new AttendeesDTO();
            // Copy relevant fields from entity to DTO
            attendeesDTO.setAttendees_id(attendees.getAttendees_id());
            attendeesDTO.setFullname(attendees.getFullname());
            attendeesDTO.setEmail(attendees.getEmail());
            attendeesDTO.setPhone(attendees.getPhone());
            attendeesDTO.setUser_message(attendees.getUser_message());
            attendeesDTO.setHas_attended(attendees.isHas_attended());
            // Set other fields as needed
            return attendeesDTO;
        }
    }
}

