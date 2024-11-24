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
}
