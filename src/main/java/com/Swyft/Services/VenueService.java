package com.Swyft.Services;

import com.Swyft.Entity.Venues;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

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
                resp.setVenue(venuesSaved); // Assuming you have a setter for event in EventsDTO
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
            // Retrieve the existing venues from the database using the provided venue_id
            Optional<Venues> optionalVenues = venueRepository.findById(venueRequest.getVenue_id());
            if (optionalVenues.isPresent()) {
                Venues venues = optionalVenues.get();

                // Update the fields of the existing event with the values from the request
                venues.setVenue_name(venueRequest.getVenue_name());
                venues.setAddress(venueRequest.getAddress());
                venues.setCapacity(venueRequest.getCapacity());
                venues.setFacilities(venueRequest.getFacilities());

                // Save the updated event
                Venues venuesSaved = venueRepository.save(venues);

                // Set the updated event in the response
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
}
