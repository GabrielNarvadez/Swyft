package com.Swyft.Controllers;

import com.Swyft.DTO.EventsDTO;
import com.Swyft.Services.EventsService;
import com.Swyft.Services.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class EventsControllers {

    private final EventsService eventsService;
    private final StorageService storageService;

    @Autowired
    public EventsControllers(EventsService eventsService, StorageService storageService) {
        this.eventsService = eventsService;
        this.storageService = storageService;
    }

    @PostMapping("event/create")
    public ResponseEntity<EventsDTO> createEvent(@RequestBody EventsDTO create){
        return ResponseEntity.ok(eventsService.createEvent(create)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @PutMapping("event/update/{eventId}")
    public ResponseEntity<EventsDTO> updateEvent(@PathVariable int eventId, @RequestBody EventsDTO update) {
        update.setId(eventId);
        return ResponseEntity.ok(eventsService.updateEvent(update)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @DeleteMapping("event/delete/{eventId}")
    public ResponseEntity<EventsDTO> deleteEvent(@PathVariable int eventId) {
        return ResponseEntity.ok(eventsService.deleteEvent(eventId)); //NAME OF HTML FILE TO BE RETURNED HERE
    }

    @PostMapping("/event/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = storageService.uploadImageToFileSystem(file);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/event/fileSystem/Images/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData = storageService.downloadImageFromFileSystem(fileName);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }
}
