package com.Swyft.Services;

import com.Swyft.DTO.AttendeesDTO;
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
            attendees.setEvent_id(attendees.getEvent_id());

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

    public AttendeesDTO deleteAttendees(Integer attendeesID, Integer eventId) {
        AttendeesDTO resp = new AttendeesDTO();
        try {
            // Ensure both attendeesID and eventId are not null
            if (attendeesID == null || eventId == null) {
                resp.setStatusCode(400);
                resp.setMessage("Attendee ID and Event ID cannot be null");
                return resp;
            }

            // Updating the event attendee count
            Optional<Events> eventOptional = eventsRepository.findById(eventId);
            if (eventOptional.isPresent()) {
                // Deleting the attendee
                attendeesRepository.deleteById(attendeesID);
                resp.setMessage("Successfully Deleted Attendee");

                Events event = eventOptional.get();
                int newAttendeeCount = event.getAttendee_count() - 1;
                event.setAttendee_count(newAttendeeCount);
                eventsRepository.save(event);  // Save the updated event

                resp.setMessage("Successfully Updated Event Attendee Count");
            } else {
                resp.setMessage("Event not found");
                resp.setStatusCode(404);
            }
        } catch (Exception e) {
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

