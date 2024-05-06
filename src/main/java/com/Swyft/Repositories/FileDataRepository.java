package com.Swyft.Repositories;

import com.Swyft.Entity.FileData;
import com.Swyft.Entity.ImageData;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileDataRepository extends JpaRepository<FileData,Integer> {
    Optional<FileData> findByName(String fileName);
}