package com.Swyft.DTO;

import com.Swyft.Entity.Events;
import com.Swyft.Entity.OurUsers;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class EventsDTO {

    // Fields representing event data
    private Integer event_id; // Added ID field
    private LocalDate date_posted; //Added DATE field
    private Integer days_ago;
    private Integer rng;

    @NotEmpty(message = "Event title required")
    private String event_title;

    @NotEmpty(message = "Event location required")
    private String location;

    private Integer date;

    @NotEmpty(message = "Event details required")
    private String details;

    // Additional fields for status information
    private String message;
    private String error;
    private int statusCode;

    // Field for holding the event object
    private Events event;

    private Integer attendee_count;
    // Constructor to set the event object
    public EventsDTO() {
    }

    // Getter and Setter for ID
    public Integer getEvent_Id() {
        return event_id;
    }

    public void setEventId(Integer event_id) {
        this.event_id = event_id;
    }

    // Setter for Events
    public void setEvent(Events event) {
        this.event = event;
    }

    public String getTitle() {
        return event_title;
    }

    public Integer getAttendee_count() {
        return attendee_count;
    }

    public void setAttendee_count(Integer attendee_count) {
        this.attendee_count = attendee_count;
    }

    public LocalDate getDate_posted() {
        return date_posted;
    }

    public void setDate_posted(LocalDate date_posted) {
        this.date_posted = date_posted;
    }

    public Integer getDays_ago() {
        return days_ago;
    }

    public void setDays_ago(Integer days) {
        this.days_ago = days_ago;
    }

    public void setTitle(String title) {this.event_title = title;
    }

    public Integer getRng() {
        return rng;
    }

    public void setRng(Integer rng) {
        this.rng = rng;
    }

    private List<Events> EventsList;

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }
}

