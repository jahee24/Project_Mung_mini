package com.mung.square.payment.controller;

import com.mung.square.dto.ApproveResponse;
import com.mung.square.dto.CancelResponse;
import com.mung.square.dto.OrderCreateForm;
import com.mung.square.dto.ReadyResponse;
import com.mung.square.payment.service.KakaoPayService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/kakaopay")
public class kakaopayController {
    @GetMapping
    public String kakaopay() {
        return "/include/kakaopayContent";
    }

    private final KakaoPayService kakaoPayService;

    @PostMapping("/ready")
    @ResponseBody
    public ReadyResponse payReady(@RequestBody OrderCreateForm orderCreateForm) {
        String name = orderCreateForm.getName();
        int totalPrice = orderCreateForm.getTotalPrice();

        // 카카오 결제 준비하기
        ReadyResponse readyResponse = kakaoPayService.payReady(name, totalPrice);
        // 세션에 결제 고유번호(tid) 저장
        SessionUtils.addAttribute("tid", readyResponse.getTid());
        System.out.println(readyResponse);
        return readyResponse;
    }

    @GetMapping("/completed")
    public String payCompleted(@RequestParam("pg_token") String pgToken) {
        String tid = SessionUtils.getStringAttributeValue("tid");

        // 카카오 결제 요청하기
        ApproveResponse approveResponse = kakaoPayService.payApprove(tid, pgToken);
        System.out.println(approveResponse);
        return "/include/kakaopaySuccess";
    }

    @PostMapping("/refund")
    public ResponseEntity<CancelResponse> refund() {
        String tid = SessionUtils.getStringAttributeValue("tid");
        System.out.println(tid);
        CancelResponse kakaocancelResponse = kakaoPayService.payCancel(tid);
        ResponseEntity<CancelResponse> response = new ResponseEntity<>(kakaocancelResponse, HttpStatus.OK);
        System.out.println(kakaocancelResponse);
        return response;
    }

    @GetMapping("/cancel")
    public String payCancel() {
        return "/include/kakaopayRefundTest";
    }
}

