package com.Swyft.Controllers;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.Services.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendeesControllers {
    private final AttendeesService attendeesService;

    @Autowired
    public AttendeesControllers(AttendeesService attendeesService) {
        this.attendeesService = attendeesService;
    }

    @PostMapping("/attendees/create/{eventId}")
    public ResponseEntity<AttendeesDTO> createAttendees(@RequestBody AttendeesDTO create, @PathVariable int eventId) {
        AttendeesDTO result = attendeesService.createAttendees(create, eventId);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/attendees/delete/{attendeesId}")
    public ResponseEntity<AttendeesDTO> deleteAttendees(@PathVariable int attendeesId) {
        AttendeesDTO result = attendeesService.deleteAttendees(attendeesId);
        return ResponseEntity.ok(result);
    }
}
