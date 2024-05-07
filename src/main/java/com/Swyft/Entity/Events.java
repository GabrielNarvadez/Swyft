package com.Swyft.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;
    private String event_title;
    private String date;
    private String details;
    private String location;
    private int event_venue_id;
    private Integer attendee_count;

    // Getters and setters
    public int getEvent_id() {
        return event_id;
    }

    public void setId(int event_id) {
        this.event_id = this.event_id;
    }

    public String getTitle() {
        return event_title;
    }

    public void setTitle(String title) {
        this.event_title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getAttendee_count() {
        return attendee_count;
    }

    public void setAttendee_count(Integer attendee_count) {
        this.attendee_count = attendee_count;
    }

    public void setDate(String date) { this.date = date;
    }

    public String getDate() {
        return date;
    }

}
