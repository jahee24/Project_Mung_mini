package com.mung.square.mypage.controller;

import com.mung.square.dto.DogDTO;
import com.mung.square.dto.UserDTO;
import com.mung.square.mypage.service.MyPageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
//@RequestMapping("/mypage")
@RequiredArgsConstructor
public class MyPageController {
    private final MyPageService service;
    @GetMapping("/mypage")
    public String myPage(Model model,String id) {
        UserDTO user = service.getUser(id);
        List<DogDTO> dog = service.getDog(id);
        model.addAttribute("user", user);
        model.addAttribute("dog", dog);
        return "include/mypageContent";
    }
    @GetMapping("/dog/register")
    public String myPageDogPro() {
        return "menu/dogRegister";
    }
    @GetMapping("/dog/profile")
    public String myPageDogReg() {
        return "menu/dogProfile";
    }

}


