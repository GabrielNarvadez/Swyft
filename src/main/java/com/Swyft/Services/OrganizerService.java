package com.Swyft.Services;

import com.Swyft.DTO.EventsDTO;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Entity.Events;
import com.Swyft.Entity.Organizer;
import com.Swyft.DTO.OrganizerDTO;
import com.Swyft.Repositories.OrganizerRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrganizerService {
    @Autowired
    private OrganizerRepository organizerRepository;

    public OrganizerDTO createOrganizer(OrganizerDTO organizerRequest) {
        OrganizerDTO resp = new OrganizerDTO();
        try {
            Organizer organizer = new Organizer();

            organizer.setOrganizer_name(organizerRequest.getOrganizer_name());
            organizer.setContact_info(organizerRequest.getContact_info());
            organizer.setEvents_organized(organizerRequest.getEvents_organized());

            Organizer organizerSaved = organizerRepository.save(organizer);

            if (organizerSaved.getOrganizer_name().equals(organizerRequest.getOrganizer_name())) {
                resp.setOrganizer(organizerSaved); // Assuming you have a setter for organizer in OrganizerDTO
                resp.setMessage("Successfully Saved");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }

    public OrganizerDTO updateOrganizer(OrganizerDTO organizerRequest) {
        OrganizerDTO resp = new OrganizerDTO();
        try {
            // Retrieve the existing organizer from the database using the provided organizer_id
            Optional<Organizer> optionalOrganizer = organizerRepository.findById(organizerRequest.getOrganizer_id());
            if (optionalOrganizer.isPresent()) {
                Organizer organizer = optionalOrganizer.get();

                // Update the fields of the existing organizer with the values from the request
                organizer.setOrganizer_name(organizerRequest.getOrganizer_name());
                organizer.setContact_info(organizerRequest.getContact_info());
                organizer.setEvents_organized(organizerRequest.getEvents_organized());

                Organizer organizerSaved = organizerRepository.save(organizer);

                // Set the updated event in the response
                resp.setOrganizer(organizerSaved);
                resp.setMessage("Successfully Updated");
            } else {
                resp.setStatusCode(404);
                resp.setMessage("Venue not found");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    public List<OrganizerDTO> findAllOrganizers() {
        return organizerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public OrganizerDTO deleteOrganizer(int organizerID) {
        OrganizerDTO resp = new OrganizerDTO();
        try {
            organizerRepository.deleteById(organizerID);
            resp.setMessage("Successflly Deleted");
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }

    private OrganizerDTO convertToDTO(Organizer organizer) {
        OrganizerDTO dto = new OrganizerDTO();
        dto.setOrganizer_id(organizer.getOrganizer_id());
        dto.setEvents_organized(organizer.getEvents_organized());
        dto.setContact_info(organizer.getContact_info());
        // Add other fields if necessary
        return dto;
    }
}
