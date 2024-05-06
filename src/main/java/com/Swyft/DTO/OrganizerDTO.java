package com.Swyft.DTO;

import com.Swyft.Entity.Organizer;
import com.Swyft.Entity.Venues;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrganizerDTO {
    // Fields representing organizer data
    private Integer organizer_id; // Added ID field

    @NotEmpty(message = "Venue name required")
    private String organizer_name;

    @NotEmpty(message = "Address required")
    private String contact_info;

    @NotEmpty(message = "Facility/Facilities required")
    private String events_organized;

    // Additional fields for status information
    private String message;
    private String error;
    private int statusCode;

    // Field for holding the event object
    private Organizer organizer;

    // Constructor to set the venue object
    public OrganizerDTO() {
    }

    public Integer getOrganizer_id() {
        return organizer_id;
    }

    public void setOrganizer_id(Integer organizer_id) {
        this.organizer_id = organizer_id;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }
}
