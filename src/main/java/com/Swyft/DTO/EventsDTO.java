package com.Swyft.DTO;

import com.Swyft.Entity.Events;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class EventsDTO {

    // Fields representing event data
    @NotEmpty(message = "Event title required")
    private String title;

    @NotEmpty(message = "Event location required")
    private String location;

    @NotEmpty(message = "Event date required")
    private String date;

    @NotEmpty(message = "Event details required")
    private String details;

    // Additional fields for status information
    private String message;
    private String error;
    private int statusCode;

    // Field for holding the event object
    private Events event;

    // Constructor to set the event object
    public EventsDTO() {
        this.event = event;
    }
}
