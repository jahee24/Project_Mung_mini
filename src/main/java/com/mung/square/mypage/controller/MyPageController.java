package com.mung.square.mypage.controller;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@SessionAttributes("user")
public class MyPageController {
    private final MyPageService service;

    @GetMapping("")
    public String myPage(@ModelAttribute("user") UserDTO user, Model model) {
        List<DogDTO> dog = service.getDogList(user.getEmail());
        model.addAttribute("dog", dog);
        return "include/mypageContent";
    }

    @GetMapping("/dogRegister")
    public String myPageDogPro() {
        return "menu/dogRegister";
    }

    @GetMapping("/dogProfile")
    public String myPageDogReg() {
        return "menu/dogProfile";
    }
}