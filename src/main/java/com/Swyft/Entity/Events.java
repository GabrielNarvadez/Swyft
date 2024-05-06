package com.Swyft.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String event_title;
    private String date;
    private String details;
    private String location;
    private Integer attendee_count;

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
