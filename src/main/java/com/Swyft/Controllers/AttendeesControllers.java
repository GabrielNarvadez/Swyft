package com.Swyft.Controllers;

import com.Swyft.DTO.AttendeesDTO;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Services.AttendeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attendees") // Adjusted base mapping
public class AttendeesControllers {

    private final AttendeesService attendeesService;
    private final AttendeesService markAttendance;
    private final AttendeesService. AttendanceService attendanceService;

    public AttendeesControllers(AttendeesService attendeesService, AttendeesService markAttendance, AttendeesService.AttendanceService attendanceService) {
        this.attendeesService = attendeesService;
        this.markAttendance = markAttendance;
        this.attendanceService = attendanceService;
    }

    @PostMapping("/create")
    public ResponseEntity<AttendeesDTO> createAttendees(@RequestBody AttendeesDTO create) {

        int eventId = create.getEvent_id();


        AttendeesDTO result = attendeesService.createAttendees(create, eventId);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<AttendeesDTO> deleteAttendees(AttendeesDTO attendeesDTO, EventsDTO eventsDTO, Integer attendees_id, Integer eventId) {
        AttendeesDTO result = attendeesService.deleteAttendees(attendeesDTO,eventsDTO,attendees_id, eventId);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/mark/attendance={attendees_id}")
    public ResponseEntity<Boolean> markAttendance(@PathVariable int attendees_id, @RequestBody AttendeesDTO attendeesDTO) {

        attendanceService.markAttendance(attendees_id, attendeesDTO);

        return ResponseEntity.ok(true);
    }
}


