
package com.Swyft.Classes;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Setter
@Getter
@Entity
@Table


public class Events {
    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence")

    private long event_id;
    private String event_name;
    private String event_date;

    //Constructor for the main class
    public Events() {

        // TODO Auto-generated constructor stub
    }


//Constructors for all

    public Events(long event_id, String event_name, String event_date) {
        this.event_id = event_id;
        this.event_name = event_name;
        this.event_date = event_date;
    }

    //Constructors No ID
    public Events(String event_name, String event_date) {
        super();
        this.event_name = event_name;
        this.event_date = event_date;
    }


    @Override
    public String toString() {
        return "Event [event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date + "]";
    }



}
