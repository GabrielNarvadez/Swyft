package com.Swyft.Controllers;

import com.Swyft.DTO.EventsDTO;
import com.Swyft.DTO.RequestDTO;
import com.Swyft.DTO.VenueDTO;
import com.Swyft.Entity.Organizer;
import com.Swyft.DTO.OrganizerDTO;
import com.Swyft.Repositories.OrganizerRepository;
import com.Swyft.Services.OrganizerService;
import jakarta.validation.Valid;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/organizer")
public class OrganizerController  {

    private final OrganizerService organizerService;

    @Autowired
    public OrganizerController(OrganizerService organizerService) {
        this.organizerService = organizerService;
    }

    @PostMapping("/create")
    public  ResponseEntity<OrganizerDTO> createOrganizer(@RequestBody OrganizerDTO create) {
        return ResponseEntity.ok(organizerService.createOrganizer(create));
    }

    @PutMapping("/update/id={organizerId}")
    public ResponseEntity<OrganizerDTO> updateOrganizer(@PathVariable int organizerId, @Valid @RequestBody OrganizerDTO update) {
        update.setOrganizer_id(organizerId);
        return ResponseEntity.ok(organizerService.updateOrganizer(update));
    }
    @DeleteMapping("/delete/id={organizerId}")
    public ResponseEntity<OrganizerDTO> deleteOrganizer(@PathVariable int organizerId) {
        return ResponseEntity.ok(organizerService.deleteOrganizer(organizerId));
    }
    @GetMapping("/get")
    public ResponseEntity<List<OrganizerDTO>> getAllOrganizers() {
        List<OrganizerDTO> organizers = organizerService.findAllOrganizers();
        return ResponseEntity.ok(organizers);
    }
}
