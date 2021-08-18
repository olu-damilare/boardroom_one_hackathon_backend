package com.example.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ImageCropperApplication {

    public static void main(String[] args) {

        SpringApplication.run(ImageCropperApplication.class, args);

    }

    @Bean
    public Cloudinary setUp(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "damilare",
                "api_key", "737177149221658",
                "api_secret", "396dCUv6airvrACqo1IhQ7Ez-Ro"));
    }

}
