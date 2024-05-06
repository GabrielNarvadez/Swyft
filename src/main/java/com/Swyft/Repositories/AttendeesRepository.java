package com.Swyft.Repositories;

import com.Swyft.Entity.Attendees;
import com.Swyft.Entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeesRepository extends JpaRepository<Attendees, Integer> {
}

