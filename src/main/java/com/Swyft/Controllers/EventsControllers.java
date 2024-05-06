package com.Swyft.Controllers;

import com.Swyft.DTO.RequestDTO;
import com.Swyft.Entity.Events;
import com.Swyft.DTO.EventsDTO;
import com.Swyft.Repositories.EventsRepository;
import com.Swyft.Services.EventsService;
import com.Swyft.Services.StorageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.*;

@RestController
public class EventsControllers {


    private final EventsService eventsService;
    private StorageService service;

    @Autowired
    public EventsControllers(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @PostMapping("event/create")
    public ResponseEntity<EventsDTO> createEvent(@RequestBody EventsDTO create){
        return ResponseEntity.ok(eventsService.createEvent(create)); //NAME OF HTML FILE TO BE RETURNED HERE
    }
    @PutMapping("event/update/{eventId}")
    public ResponseEntity<EventsDTO> updateEvent(@PathVariable int eventId, @Valid @RequestBody EventsDTO update) {
        update.setId(eventId);
        return ResponseEntity.ok(eventsService.updateEvent(update)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @DeleteMapping("event/delete/{eventId}")
    public ResponseEntity<EventsDTO> deleteEvent(@PathVariable int eventId) {
        return ResponseEntity.ok(eventsService.deleteEvent(eventId)); //NAME OF HTML FILE TO BE RETURNED HERE
    }
    @PostMapping("/event/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }
    @GetMapping("/event/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=service.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }
}