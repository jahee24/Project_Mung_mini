package com.mung.square.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "layout/mainPage";
    }

    @GetMapping("/resv")
    public String resv() {
        return "menu/resv";
    }

    @GetMapping("/support/qna")
    public String support() {
        return "menu/qna";
    }
    @GetMapping("/support/notice")
    public String myPage() {
        return "menu/mypage";
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
