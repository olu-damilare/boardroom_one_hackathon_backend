package com.example.image.upload.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface BgRemovalService {

    byte[] removeBg(MultipartFile file) throws IOException;

}
