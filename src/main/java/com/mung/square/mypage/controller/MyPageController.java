package com.mung.square.mypage.controller;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.List;


@Controller
@RequestMapping("/mypage")
@RequiredArgsConstructor
@SessionAttributes({"user", "dog"})
public class MyPageController {
    private final MyPageService service;
    @GetMapping("/")
    public String myPage(@ModelAttribute("user") UserDTO user,Model model) {
        List<DogDTO> dog = service.getDog(user.getEmail());
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


