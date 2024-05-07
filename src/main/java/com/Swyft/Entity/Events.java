package com.Swyft.Entity;


import jakarta.persistence.*;
import java.time.*;
//functionality crutch lmao
import java.util.Random;

@Entity
@Table(name = "Events")
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    private String event_title;
    private Integer date;
    private String details;
    private String location;
    private Integer attendee_count;
    private LocalDate date_posted;
    private Integer days_ago;
    private Integer rng;

    // Getters and setters
    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
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

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
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

    public void setDays_ago(Integer days_ago) {
        this.days_ago = days_ago;
    }

    public Integer getRng() {
        return rng;
    }

    public void setRng() {
        Random random = new Random();
        this.rng = random.nextInt(1000);
    }
}
