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

    @PostMapping("/events")
    public ResponseEntity<EventsDTO> createEvent(@RequestBody EventsDTO create){
        return ResponseEntity.ok(eventsService.createEvent(create)); //NAME OF HTML FILE TO BE RETURNED HERE
    }




}