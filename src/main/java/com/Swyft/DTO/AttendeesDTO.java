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
    private int Attendees_id;
    private String message;
    private String error;
    private int statusCode;

    @NotEmpty(message = "Name required")
    private String fullname;

    @NotEmpty(message = "Email required")
    private String email;

    @NotEmpty(message = "Phone required")
    private Integer phone;

    private String user_message;
    private Attendees attendees;

    public int getAttendees_id() {
        return Attendees_id;
    }

    public void setAttendees_id(int attendees_id) {
        Attendees_id = attendees_id;
    }
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
}
