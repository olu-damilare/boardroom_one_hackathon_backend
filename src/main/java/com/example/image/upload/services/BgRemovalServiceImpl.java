package com.example.image.upload.services;

import org.apache.http.client.fluent.Request;
import org.apache.http.client.fluent.Response;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class BgRemovalServiceImpl implements BgRemovalService {

    @Override
    public byte[] removeBg(MultipartFile file) throws IOException {

        Response response = Request.Post("https://api.remove.bg/v1.0/removebg")
                .addHeader("X-Api-Key", "xDTc6RwrL7nWdMNm8ZGjFTNJ")
                .body(
                        MultipartEntityBuilder.create()
                                .addBinaryBody("image_file", file.getInputStream())
                                .addTextBody("size", "auto")
                                .build()
                ).execute();
      return  response.returnContent().asBytes();

    }

}
