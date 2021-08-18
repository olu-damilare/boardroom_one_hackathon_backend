package com.example.image.upload.services;

import java.io.IOException;
import java.util.Map;

import com.cloudinary.*;

import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageCropServices {

    private Cloudinary cloudinary;
    @Autowired
    private BgRemovalService bgRemovalService;


    @Autowired
    public ImageServiceImpl(Cloudinary cloudinary) {
        this.cloudinary = cloudinary;
    }

    @Override
    public Map<?, ?> uploadImage(MultipartFile file) throws IOException {
        byte[] byteContent = bgRemovalService.removeBg(file);

        Map<?, ?> imageProperties = ObjectUtils.asMap("transformation", new Transformation()
                .background("black")
                .gravity("face")
                .height(700)
                .width(700)
                .crop("fill")
                .chain()
                .opacity(50).chain());

         return cloudinary.uploader().upload(byteContent, imageProperties);
    }


}
