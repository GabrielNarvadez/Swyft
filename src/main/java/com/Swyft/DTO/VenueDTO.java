package com.Swyft.DTO;

import com.Swyft.Entity.Events;
import com.Swyft.Entity.Venues;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class VenueDTO {

    // Fields representing venue data
    private Integer venue_id; // Added ID field

    @NotEmpty(message = "Venue name required")
    private String venue_name;

    @NotEmpty(message = "Address required")
    private String address;

    @NotEmpty(message = "Venue Capacity required")
    private Integer capacity;

    @NotEmpty(message = "Facility/Facilities required")
    private String facilities;

    // Additional fields for status information
    private String message;
    private String error;
    private int statusCode;

    // Field for holding the event object
    private Venues venue;

    // Constructor to set the venue object
    public VenueDTO() {
    }

    public Integer getVenue_id() {
        return venue_id;
    }

    public void setVenue_id(Integer venue_id) {
        this.venue_id = venue_id;
    }

    // Setter for Venues
    public void setVenue(Venues venue) {
        this.venue = venue;
    }
}
