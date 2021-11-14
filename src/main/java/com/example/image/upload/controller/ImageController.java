package com.example.image.upload.controller;

import com.example.image.upload.services.ImageCropServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/upload")
@Slf4j
public class ImageController {

    @Autowired
    ImageCropServices imageCropServices;

    @PostMapping
    public ResponseEntity<?> addImage(@RequestParam("file") MultipartFile file) throws IOException {

        try {
            log.info("this worked");
            return new ResponseEntity<>(imageCropServices.uploadImage(file), HttpStatus.OK);
        } catch (Exception ex) {
            log.error("didn't work -> {}", imageCropServices.uploadImage(file));
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }
}
