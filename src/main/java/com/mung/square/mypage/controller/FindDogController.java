package com.mung.square.mypage.controller;

import com.mung.square.dto.DogDTO;
import com.mung.square.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FindDogController {
    private final MyPageService service;
    @GetMapping(value = "/mypage/dogProfile/{dogId}", produces = "application/json;charset=utf-8")
    public DogDTO myPageDogProfile(@PathVariable String dogId) {
        System.out.println("Getmapping");
        DogDTO dog = service.getDogById(dogId);
        System.out.println(dogId);
        System.out.println(dog);
        return dog;
    }
}
