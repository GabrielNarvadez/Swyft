package com.Swyft.DTO;

import com.Swyft.Entity.Attendees;
import com.Swyft.Entity.Events;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class AttendeesDTO {
    private String message;
    private String error;
    private int statusCode;
    private int event_id;

    @NotEmpty(message = "Name required")
    private String fullname;

    @NotEmpty(message = "Email required")
    private String email;

    @NotEmpty(message = "Phone required")
    private Long phone;

    private String user_message;
    private Attendees attendees;


    public void setAttendees(Attendees attendees) {
        this.attendees = attendees;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String error_message) {
        this.message = error_message;
    }

    public String getUser_message() {
        return user_message;
    }

    public void setUser_message(String user_message) {
        this.user_message = user_message;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
}
