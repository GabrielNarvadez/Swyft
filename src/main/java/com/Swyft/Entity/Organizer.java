package com.Swyft.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Organizer")
@Data
public class Organizer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int organizer_id;

    private String organizer_name;
    private String contact_info;
    private String events_organized;

    @Column(columnDefinition = "TEXT")

    public int getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(int organizer_id) {
        this.organizer_id = organizer_id;
    }

    public String getOrganizer_name() {
        return organizer_name;
    }

    public void setOrganizer_name(String organizer_name) {
        this.organizer_name = organizer_name;
    }

    public String getContact_info() {
        return contact_info;
    }

    public void setContact_info(String contact_info) {
        this.contact_info = contact_info;
    }

    public String getEvents_organized() {
        return events_organized;
    }

    public void setEvents_organized(String events_organized) {
        this.events_organized = events_organized;
    }
}
