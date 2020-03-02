package com.app.fogether.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.fogether.service.UserImageService;

@RestController
@RequestMapping("/images")
public class UserImageController {

	@Autowired
    private UserImageService userImageService;

    @PostMapping("/uploadImage")
    public String uploadImage(@RequestPart(value = "file") MultipartFile file,
    		@RequestPart(value = "userId") String userId,
    		 @RequestPart(value = "description") String description){
        return this.userImageService.uploadFile(file, Long.parseLong(userId), description);
    }
}