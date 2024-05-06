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
}
