package com.example.BackenMotorcycle.services;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    void init() throws Exception;

    String product(MultipartFile file);

    Resource loadAsResource(String fileName);
}
