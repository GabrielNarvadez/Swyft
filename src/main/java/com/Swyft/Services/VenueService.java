package com.Swyft.Services;

import com.Swyft.DTO.EventsDTO;
import com.Swyft.DTO.OrganizerDTO;
import com.Swyft.Entity.Organizer;
import com.Swyft.Entity.Venues;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class VenueService {
    @Autowired
    private VenueRepository venueRepository;

    public VenueDTO createVenue(VenueDTO venueRequest) {
        VenueDTO resp = new VenueDTO();
        try {
            Venues venues = new Venues();

            venues.setVenue_name(venueRequest.getVenue_name());
            venues.setAddress(venueRequest.getAddress());
            venues.setCapacity(venueRequest.getCapacity());
            venues.setFacilities(venueRequest.getFacilities());

            Venues venuesSaved = venueRepository.save(venues);

            if (venuesSaved.getVenue_name().equals(venueRequest.getVenue_name())) {
                resp.setVenue(venuesSaved);
                resp.setMessage("Successfully Saved");
            }
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());

        }
        return resp;
    }
    public VenueDTO updateVenue(VenueDTO venueRequest) {
        VenueDTO resp = new VenueDTO();
        try {
            Optional<Venues> optionalVenues = venueRepository.findById(venueRequest.getVenue_id());
            if (optionalVenues.isPresent()) {
                Venues venues = optionalVenues.get();


                venues.setVenue_name(venueRequest.getVenue_name());
                venues.setAddress(venueRequest.getAddress());
                venues.setCapacity(venueRequest.getCapacity());
                venues.setFacilities(venueRequest.getFacilities());

                Venues venuesSaved = venueRepository.save(venues);

                resp.setVenue(venuesSaved);
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
    public List<VenueDTO> findAllVenues() {
        return venueRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }
    public VenueDTO deleteVenue(int venueID) {
        VenueDTO resp = new VenueDTO();
        try {
            venueRepository.deleteById(venueID);
            resp.setMessage("Successfully Deleted");
        } catch (Exception e) {
            resp.setStatusCode(500);
            resp.setError(e.getMessage());
        }
        return resp;
    }
    private VenueDTO convertToDTO(Venues venues) {
        VenueDTO dto = new VenueDTO();
        dto.setVenue_id(venues.getVenue_id());
        dto.setVenue_name(venues.getVenue_name());
        dto.setAddress(venues.getAddress());
        dto.setCapacity(venues.getCapacity());
        dto.setFacilities(venues.getFacilities());
        // Add other fields if necessary
        return dto;
    }
}
