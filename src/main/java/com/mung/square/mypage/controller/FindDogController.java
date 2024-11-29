package com.mung.square.mypage.controller;

import com.mung.square.dto.DogDTO;
import com.mung.square.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("mypage")
public class FindDogController {
    private final MyPageService service;
    @Value("${mypage.upload.dir}")
    private String uploadDir;

    @GetMapping(value = "/dogProfile/{dogId}", produces = "application/json;charset=utf-8")
    public DogDTO myPageDogProfile(@PathVariable String dogId) {
        System.out.println("Getmapping");
        DogDTO dog = service.getDogById(dogId);
        System.out.println(dogId);
        System.out.println(dog);
        File file = new File(uploadDir + "/" + dog.getImageUrl());

        return dog;
    }



}
