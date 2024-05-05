package com.Swyft.Repositories;

import com.Swyft.Entity.Events;
import com.Swyft.Entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventsRepository extends JpaRepository<Events, Integer> {
}
