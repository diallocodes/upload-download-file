package com.diallocode.storageimage.service;

import com.diallocode.storageimage.model.ImageData;
import com.diallocode.storageimage.repository.StorageRepository;
import com.diallocode.storageimage.utils.ImageUtils;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@AllArgsConstructor
@Slf4j
@Service
public class StorageService {

    private final StorageRepository repository;

    public String uploadImage(MultipartFile file) throws IOException {
                 repository.save(ImageData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtils.compressImage(file.getBytes())).build());
        return "file uploaded successfully "+ file.getOriginalFilename();
    }

    public byte[] downloadedImage(String fileName) {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
        return ImageUtils.decompressionImage(dbImageData.get().getImageData());
    }
}
