package com.Swyft.Repositories;

import com.Swyft.Entity.Organizer;
import com.Swyft.Entity.OurUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OrganizerRepository extends JpaRepository<Organizer, Integer> {
}
