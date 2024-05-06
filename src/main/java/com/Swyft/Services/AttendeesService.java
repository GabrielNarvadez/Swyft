package com.Swyft.Services;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.Entity.Attendees;
import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.AttendeesRepository;
import com.Swyft.Repositories.EventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AttendeesService {
    @Autowired
    private AttendeesRepository attendeesRepository;


    public AttendeesDTO createAttendees(AttendeesDTO attendeesRequest) {
        AttendeesDTO resp = new AttendeesDTO();
        try {
            Attendees attendees = new Attendees();

            attendees.setFullname(attendeesRequest.getFullname());
            attendees.setEmail(attendeesRequest.getEmail());
            attendees.setPhone(attendeesRequest.getPhone());
            attendees.setUser_message(attendeesRequest.getUser_message());

            Attendees attendeesSaved = attendeesRepository.save(attendees);

            if (attendeesSaved.getFullname().equals(attendeesRequest.getFullname())) {
                resp.setAttendees(attendeesSaved); // Assuming you have a setter for event in EventsDTO
                resp.setMessage("Successfully Saved Attendee");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }

    public AttendeesDTO deleteAttendees(int attendeesID) {
        AttendeesDTO resp = new AttendeesDTO();
        try {
            attendeesRepository.deleteById(attendeesID);
            resp.setMessage("Successfully Deleted");
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
}
