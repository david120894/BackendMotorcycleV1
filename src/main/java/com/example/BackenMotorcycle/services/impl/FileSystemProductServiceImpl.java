package com.example.BackenMotorcycle.services.impl;

import com.example.BackenMotorcycle.services.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileSystemProductServiceImpl implements ProductService {
    @Value("${media.location.image}")
    private String imageLocation;
    private Path imagePath;

    @Override
    public void init() throws Exception {
        imagePath = Paths.get(imageLocation);
        Files.createDirectories(imagePath);
    }

    @Override
    public String product(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("FIle is empty");
            }
            String fileName = file.getOriginalFilename();
            Path destinationFile = imagePath.resolve(Paths.get(fileName))
                    .normalize().toAbsolutePath();
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, destinationFile, StandardCopyOption.REPLACE_EXISTING);
            }
            return fileName;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Resource loadAsResource(String fileName) {
        try {
            if (fileName == null || fileName.isEmpty()) {
                throw new RuntimeException("Filename is empty");
            }
            Path file = imagePath.resolve(fileName);
            Resource resource = new UrlResource((file.toUri()));
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("Could not read file: " + fileName);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + fileName);
        }
    }
}
