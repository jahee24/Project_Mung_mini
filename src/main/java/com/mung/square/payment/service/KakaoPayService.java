package com.mung.square.payment.service;

import com.mung.square.dto.ReadyResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoPayService {
    // 카카오페이 결제창 연결
    public ReadyResponse payReady(String name, int totalPrice) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", "1234567890");                       // 주문번호
        parameters.put("partner_user_id", "roommake");                          // 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", "1");                                        // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "0");                                 // 상품 비과세 금액
        parameters.put("approval_url", "http://127.0.0.1:5000/kakaopay/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://127.0.0.1:5000/kakaopay/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://127.0.0.1:5000/kakaopay/fail");          // 결제 실패 시 URL

        // HttpEntity : HTTP 요청 또는 응답



        return null;
    }
}
