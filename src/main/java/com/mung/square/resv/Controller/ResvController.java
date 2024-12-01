package com.mung.square.resv.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resv")
public class ResvController {
    @GetMapping
    public String resv() {
        return "/include/resvContent";
    }
}
