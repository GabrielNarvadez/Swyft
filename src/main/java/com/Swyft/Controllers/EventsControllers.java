package com.Swyft.Controllers;

import com.Swyft.DTO.RequestDTO;
import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.EventsRepository;
import com.Swyft.Services.EventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class EventsControllers {


    private final EventsService eventsService;

    @Autowired
    public EventsControllers(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping("/create")
    public ResponseEntity<EventsDTO> createEvent(@RequestBody EventsDTO create){
        return ResponseEntity.ok(eventsService.createEvent(create)); //NAME OF HTML FILE TO BE RETURNED HERE
    }
    @PutMapping("/update/{eventId}")
    public ResponseEntity<EventsDTO> updateEvent(@PathVariable int eventId, @Valid @RequestBody EventsDTO update) {
        update.setId(eventId);
        return ResponseEntity.ok(eventsService.updateEvent(update)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @DeleteMapping("/delete/{eventId}")
    public ResponseEntity<EventsDTO> deleteEvent(@PathVariable int eventId) {
        return ResponseEntity.ok(eventsService.deleteEvent(eventId)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

}