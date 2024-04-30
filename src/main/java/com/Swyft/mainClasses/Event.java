


package com.Swyft.mainClasses;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table


public class Event{
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
	public Event() {
		
		// TODO Auto-generated constructor stub
	}
	
	
//Constructors for all
	
public Event(long event_id, String event_name, String event_date) {
	this.event_id = event_id;
	this.event_name = event_name;
	this.event_date = event_date;
}

//Constructors No ID
public Event(String event_name, String event_date) {
	super();
	this.event_name = event_name;
	this.event_date = event_date;
}


public long getEvent_id() {
	return event_id;
}


public void setEvent_id(long event_id) {
	this.event_id = event_id;
}


public String getEvent_name() {
	return event_name;
}


public void setEvent_name(String event_name) {
	this.event_name = event_name;
}


public String getEvent_date() {
	return event_date;
}


public void setEvent_date(String event_date) {
	this.event_date = event_date;
}


@Override
public String toString() {
	return "Event [event_id=" + event_id + ", event_name=" + event_name + ", event_date=" + event_date + "]";
}

	

}
