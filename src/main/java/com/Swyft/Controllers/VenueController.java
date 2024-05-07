package com.Swyft.Controllers;

import com.Swyft.DTO.EventsDTO;
import com.Swyft.DTO.OrganizerDTO;
import com.Swyft.DTO.RequestDTO;
import com.Swyft.Entity.Venues;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Repositories.VenueRepository;
import com.Swyft.Services.VenueService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/venue")
public class VenueController {

    private final VenueService venueService;

    @Autowired
    public VenueController(VenueService venueService) {
        this.venueService = venueService;
    }

    @PostMapping("/create")
    public ResponseEntity<VenueDTO> createVenue(@RequestBody VenueDTO create){
        return ResponseEntity.ok(venueService.createVenue(create));
    }
    @PutMapping("/update/id={venueId}")
    public ResponseEntity<VenueDTO> updateVenue(@PathVariable int venueId, @Valid @RequestBody VenueDTO update) {
        update.setVenue_id(venueId);
        return ResponseEntity.ok(venueService.updateVenue(update));
    }
    @DeleteMapping("/delete/id={venueId}")
    public ResponseEntity<VenueDTO> deleteVenue(@PathVariable int venueId) {
        return ResponseEntity.ok(venueService.deleteVenue(venueId));
    }
    @GetMapping("/get")
    public ResponseEntity<List<VenueDTO>> getAllVenues() {
        List<VenueDTO> venues = venueService.findAllVenues();
        return ResponseEntity.ok(venues);
    }
}
