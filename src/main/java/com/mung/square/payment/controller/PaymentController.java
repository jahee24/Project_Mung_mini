package com.mung.square.payment.controller;

import com.mung.square.dto.KakaopayAuthResVo;
import com.mung.square.dto.KakaopayReq;
import com.mung.square.dto.KakaopayReqVo;
import com.mung.square.payment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    PaymentService paymentService;

    private final String CID = "TC0ONETIME";
    private final String SECRETKEY = "DEV40F6EC3ABDBDFE47E9A1C57A4C18433D83D2D";
    private final String SERVER_DOMAIN = "http://127.0.0.1:5000";

    @GetMapping
    public String payment() {
        return "include/paymentContent";
    }

    @GetMapping("/kakaopay/receive")
    public String kakaopayReceive(@RequestParam(name = "pg_token", required = false) String token, Model model) {
        model.addAttribute("resulteCd", "9999");
        model.addAttribute("token", "null");
        if(!Objects.isNull(token)) {
            model.addAttribute("token", token);
            model.addAttribute("resulteCd", "0000");
        }
        return "kakaoReceive";
    }


    @PostMapping("/kakaopay")
    @ResponseBody
    public ResponseEntity<KakaopayAuthResVo> kakaopayAuth(KakaopayReq kakaopayReq) {
        KakaopayReqVo kakaopayReqVo = new KakaopayReqVo(CID, SERVER_DOMAIN + "/kakaopay/receive", kakaopayReq);
        KakaopayAuthResVo response = paymentService.toKakaoServer(SECRETKEY, "/online/v1/payment/ready", kakaopayReqVo, KakaopayAuthResVo.class);
        return ResponseEntity.ok(response);
    }
}
