package com.example.image.upload.services;

import java.io.IOException;
import java.util.Arrays;
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
        if(file == null){
            throw new IllegalArgumentException("file cannot be null");
        }

        if(!isValidFileType(file)){
            throw new IllegalArgumentException("Invalid file type. Image type should be either jpg, jpeg or png");
        }

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

    public boolean isValidFileType(MultipartFile file){
        String validFileType = "jpg, jpeg, png";
        System.out.println(file.getOriginalFilename());
        String[] fileNameContent = file.getOriginalFilename().split("\\.");
        System.out.println(Arrays.toString(fileNameContent));
        String fileType = fileNameContent[fileNameContent.length - 1];
        System.out.println(fileType);

        return validFileType.contains(fileType.toLowerCase());
    }


}
