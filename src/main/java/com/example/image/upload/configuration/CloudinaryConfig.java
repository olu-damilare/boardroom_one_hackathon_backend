package com.example.image.upload.configuration;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration()
public class CloudinaryConfig {

    @Bean
    CommandLineRunner commandLineRunner() {

        return args -> {
            new Cloudinary(ObjectUtils.asMap(
                    "cloud_name", "damilare",
                    "api_key", "737177149221658",
                    "api_secret", "396dCUv6airvrACqo1IhQ7Ez-Ro"));

        };
    }
}
