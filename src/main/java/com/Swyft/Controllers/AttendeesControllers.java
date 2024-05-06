package com.Swyft.Controllers;


import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Services.AttendeesService;
import com.Swyft.Services.EventsService;
import com.Swyft.Services.StorageService;
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

    @PostMapping("attendees/create")
    public ResponseEntity<AttendeesDTO> createAttendees(@RequestBody AttendeesDTO create) {
        return ResponseEntity.ok(attendeesService.createAttendees(create)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @DeleteMapping("attendees/delete/{attendeesId}")
    public ResponseEntity<AttendeesDTO> deleteAttendees(@PathVariable int attendeesId) {
        return ResponseEntity.ok(attendeesService.deleteAttendees(attendeesId)); //NAME OF HTML FILE TO BE RETURNED HERE
    }
}