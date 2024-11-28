package com.mung.square.payment.controller;

import com.mung.square.dto.OrderCreateForm;
import com.mung.square.dto.ReadyResponse;
import com.mung.square.payment.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kakaopay")
public class kakaopayController {
    private final KakaoPayService kakaoPayService;

    @PostMapping("ready")
    @ResponseBody
    public ReadyResponse payReady(@RequestBody OrderCreateForm orderCreateForm) {
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();

        // 카카오 결제 준비하기
        //ReadyResponse readyResponse = kakaoPayService
        return null;
    }
}
