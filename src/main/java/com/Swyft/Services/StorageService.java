package com.Swyft.Services;

import com.Swyft.Entity.FileData;
import com.Swyft.Entity.ImageData;
import com.Swyft.Repositories.FileDataRepository;
import com.Swyft.Repositories.StorageRepository;
import com.Swyft.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH = "C:/Swyft/src/main/java/com/Swyft/Images";


    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        String filePath = FOLDER_PATH + File.separator + fileName;

        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(fileName)
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return "File uploaded successfully: " + filePath;
        }
        return null;
    }

    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath = fileData.get().getFilePath();
        byte[] images = Files.readAllBytes(new File(filePath).toPath());
        return images;
    }
}