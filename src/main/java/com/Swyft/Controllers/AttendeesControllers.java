package com.Swyft.Controllers;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.Services.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendees") // Adjusted base mapping
public class AttendeesControllers {

    private final AttendeesService attendeesService;

    @Autowired
    public AttendeesControllers(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @PostMapping("/create/{eventId}")
    public ResponseEntity<AttendeesDTO> createAttendees(@RequestBody AttendeesDTO create, @PathVariable int eventId) {
        AttendeesDTO result = attendeesService.createAttendees(create, eventId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{attendeesId}/{eventId}")
    public ResponseEntity<AttendeesDTO> deleteAttendees(@PathVariable Integer attendeesId, @PathVariable Integer eventId) {
        AttendeesDTO result = attendeesService.deleteAttendees(attendeesId, eventId);
        return ResponseEntity.ok(result);
    }
}