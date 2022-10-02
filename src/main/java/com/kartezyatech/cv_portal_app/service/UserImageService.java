package com.kartezyatech.cv_portal_app.service;

import com.kartezyatech.cv_portal_app.entity.User;
import com.kartezyatech.cv_portal_app.entity.UserImage;
import com.kartezyatech.cv_portal_app.exception.CvPortalAppException;
import com.kartezyatech.cv_portal_app.helper.ImageUploadHelper;
import com.kartezyatech.cv_portal_app.repository.UserImageRepository;
import com.kartezyatech.cv_portal_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserImageService {

    private final UserImageRepository userImageRepository;
    private final UserRepository userRepository;

    public String uploadImage(MultipartFile file, Long userId) throws IOException {

        User user = userRepository.findById(userId).orElseThrow(()->new CvPortalAppException("user not found"));

        UserImage userImage = (UserImage.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .user(user)
                .imageData(ImageUploadHelper.compressImage(file.getBytes())).build());
        userImageRepository.save(userImage);
        if (userImage != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    public byte[] downloadImageByUserId(Long userId){
        Optional<UserImage> dbImageData  =userImageRepository.findByUserId(userId);
        byte[] images=ImageUploadHelper.decompressImage(dbImageData.get().getImageData());
        return images;
    }
}
