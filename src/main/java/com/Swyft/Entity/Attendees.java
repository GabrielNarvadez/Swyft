package com.Swyft.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Attendees")
@Data
public class Attendees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int attendees_id;

    private String fullname;
    private String email;
    private Long phone;
    private String user_message;
    private Integer event_id;
    private boolean has_attended = false;

    public String getUser_message() {
        return user_message;
    }

    public void setUser_message(String user_message) {
        this.user_message = user_message;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public Integer getEvent_id() {
        return event_id;
    }

    public void setEvent_id(Integer event_id) {
        this.event_id = event_id;
    }

    public boolean isHas_attended() {
        return has_attended;
    }

    public void setHas_attended(boolean has_attended) {
        this.has_attended = has_attended;
    }
}
