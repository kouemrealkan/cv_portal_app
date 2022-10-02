package com.kartezyatech.cv_portal_app.controller;

import com.kartezyatech.cv_portal_app.service.UserImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/user-image")
public class UserImageController {

    private final UserImageService userImageService;

    @PostMapping(value = "/store-img", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<?> uploadImage(@RequestParam("file") MultipartFile file, Long userId) throws IOException {
        String uploadImage = userImageService.uploadImage(file,userId);
        return ResponseEntity.status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/get-image/by-user/{userId}")
    public ResponseEntity<?> downloadImageByUserID(@PathVariable Long userId){
        byte[] imageData=userImageService.downloadImageByUserId(userId);
        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);

    }

}
