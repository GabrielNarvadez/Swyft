package com.Swyft.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "Venues")
@Data
public class Venues {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int venue_id;

    private String venue_name;
    private String address;
    private String capacity;
    private String facilities;

    @Column(columnDefinition = "TEXT")

    public int getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(int venue_id) {
        this.venue_id = venue_id;
    }

    public String getVenue_name() {
        return venue_name;
    }

    public void setVenue_name(String venue_name) {
        this.venue_name = venue_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }
}
