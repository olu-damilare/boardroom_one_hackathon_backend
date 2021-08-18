package com.example.image.upload.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Map;

@Service
public interface ImageCropServices {

    Map<?, ?> uploadImage(MultipartFile file) throws IOException;

}
