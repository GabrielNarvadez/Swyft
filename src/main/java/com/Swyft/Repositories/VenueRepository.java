package com.Swyft.Repositories;

import com.Swyft.Entity.Venues;
import com.Swyft.Entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VenueRepository extends JpaRepository<Venues, Integer> {
}
