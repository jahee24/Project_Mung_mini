package com.mung.square.review;

import com.mung.square.dto.ReviewFileDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class FileUploadService {

    @Value("${review.upload.dir}") // application.properties에서 설정된 값을 읽음
    private String uploadPath;

    @Value("${review.download.url:/fullstack7/downloads/}") // 다운로드 URL 기본값 설정
    private String downloadUrl;

    public String getUploadPath(String filename) {
        return uploadPath + filename;
    }

    public List<ReviewFileDTO> uploadFiles(List<MultipartFile> multipartFiles) throws IOException {
        List<ReviewFileDTO> fileDTOList = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (!multipartFile.isEmpty()) {
                fileDTOList.add(uploadFile(multipartFile)); // 단일 파일 업로드 메소드 재사용
            }
        }
        return fileDTOList;
    }

    public ReviewFileDTO uploadFile(MultipartFile multipartFile) throws IOException {
        if (multipartFile.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty");
        }

        String originalFilename = multipartFile.getOriginalFilename();
        String storeFilename = createStoreFilename(originalFilename);

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        File destination = new File(getUploadPath(storeFilename));
        try {
            multipartFile.transferTo(destination);
        } catch (IOException e) {
            throw new IOException("Failed to save file: " + originalFilename, e);
        }

        if (!destination.exists() || destination.length() == 0) {
            throw new IOException("File failed to save properly: " + originalFilename);
        }

        String fileUrl = downloadUrl + storeFilename;
        return new ReviewFileDTO(
                UUID.randomUUID().toString(),
                null,
                originalFilename,
                storeFilename,
                fileUrl
        );
    }

    private String createStoreFilename(String originalFilename) {
        int position = originalFilename.lastIndexOf(".");
        String ext = position != -1 ? originalFilename.substring(position + 1) : "jpg"; // 기본 확장자 설정
        String uuid = UUID.randomUUID().toString();
        return uuid + "." + ext.toLowerCase(); // 확장자를 소문자로 변환
    }
    public String saveFile(MultipartFile file) throws IOException {
        String fileName = UUID.randomUUID().toString() + "_" + file.getOriginalFilename();
        String savePath = "C:/fullstack7/downloads/" + fileName;
        File destination = new File(savePath);

        // 디렉토리 생성 확인
        File directory = new File("C:/fullstack7/downloads/");
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // 파일 저장
        file.transferTo(destination);
        return fileName;
    }

}
