package com.Swyft.Entity;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Events")
@Data
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int event_id;

    private String event_title;
    private String date;
    private String location;
    private String details;

    @Column(columnDefinition = "TEXT")

    public String getTitle() {
        return event_title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTitle(String event_title) {
        this.event_title = event_title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public void setEvent(Events eventsSaved) {

    }
}
