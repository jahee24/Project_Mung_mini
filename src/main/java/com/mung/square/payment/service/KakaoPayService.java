package com.mung.square.payment.service;

import com.mung.square.dto.ApproveResponse;
import com.mung.square.dto.ReadyResponse;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class KakaoPayService {
    // 카카오페이 측에 요청 시 Header 에 필요한 값 입력
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization","SECRET_KEY DEV40F6EC3ABDBDFE47E9A1C57A4C18433D83D2D");
        headers.set("Content-Type", "application/json");

        return headers;
    }

    // 카카오페이 결제창 연결
    public ReadyResponse payReady(String name, int totalPrice) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");                                    // 가맹점 코드(테스트용)
        parameters.put("partner_order_id", "partner_order_id");                       // 주문번호
        parameters.put("partner_user_id", "partner_user_id");                          // 회원 아이디
        parameters.put("item_name", name);                                      // 상품명
        parameters.put("quantity", "1");                                        // 상품 수량
        parameters.put("total_amount", String.valueOf(totalPrice));             // 상품 총액
        parameters.put("tax_free_amount", "200");                                 // 상품 비과세 금액
        parameters.put("approval_url", "http://127.0.0.1:5000/mung/kakaopay/completed"); // 결제 성공 시 URL
        parameters.put("cancel_url", "http://127.0.0.1:5000/mung/kakaopay/cancel");      // 결제 취소 시 URL
        parameters.put("fail_url", "http://127.0.0.1:5000/mung/kakaopay/fail");          // 결제 실패 시 URL

        // HttpEntity : HTTP 요청 또는 응답
        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        // RestTemplate
        // : Rest 방식 API를 호출할 수 있는 Spring 내장 클래스
        //   REST API 호출 이후 응답을 받을 때까지 기다리는 동기 방식 (json, xml 응답)
        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/ready";

        // RestTemplate의 postForEntity : POST 요청을 보내고 ResponseEntity로 결과를 반환받는 메소드
        ResponseEntity<ReadyResponse> responseEntity = template.postForEntity(url, requestEntity, ReadyResponse.class);

        return responseEntity.getBody();
    }

    // 카카오페이 결제 승인
    // 사용자가 결제 수단을 선택하고 비밀번호를 입력해 결제 인증을 완료한 뒤,
    // 최종적으로 결제 완료 처리를 하는 단계
    public ApproveResponse payApprove(String tid, String pgToken) {
        Map<String, String> parameters = new HashMap<>();
        parameters.put("cid", "TC0ONETIME");
        parameters.put("tid", tid);
        parameters.put("partner_order_id", "partner_order_id");
        parameters.put("partner_user_id", "partner_user_id");
        parameters.put("pg_token", pgToken);

        HttpEntity<Map<String, String>> requestEntity = new HttpEntity<>(parameters, this.getHeaders());

        RestTemplate template = new RestTemplate();
        String url = "https://open-api.kakaopay.com/online/v1/payment/approve";
        ApproveResponse approveResponse = template.postForObject(url, requestEntity, ApproveResponse.class);

        return approveResponse;
    }
}
