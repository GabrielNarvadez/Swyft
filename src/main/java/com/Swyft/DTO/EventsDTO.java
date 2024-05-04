package com.Swyft.DTO;

import com.Swyft.Entity.Events;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsDTO {

    // Fields representing event data
    private Integer id; // Added ID field

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
    }

    // Getter and Setter for ID
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Setter for Events
    public void setEvent(Events event) {
        this.event = event;
    }
}
