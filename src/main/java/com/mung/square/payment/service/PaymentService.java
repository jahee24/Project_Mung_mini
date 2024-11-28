package com.mung.square.payment.service;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Service
public class PaymentService {
    public <T> T toKakaoServer(String secretKey, String url, Object reqBody, Class<T> resp) {
        URI uri = UriComponentsBuilder
                .fromUriString("https://open-api.kakaopay.com") // 서버 경로 설정(Host)
                .path(url) // 서버 경로 설정(path)
                .build() // 위 설정 값을 uri에 입력, return 값은 UriComponents 로 되어 있음
                .toUri(); // toUri 로 원하는 URI 타입으로 변경해줌

        // 카카오 서버 요청 정보에 따른 header 요청 정보 전송
        // secret key 에 관리자 key(test 시 dev key) 전송
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "SECRET_KEY " + secretKey);

        // 서버에 전송 될 데이터 규격을 Json 으로 설정
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);

        // 카카오 서버로 전송할 데이터 내용(reqBody)과 header 를 동시에 관리
        HttpEntity<Object> requestsMessage = new HttpEntity<>(reqBody, httpHeaders);

        // RestTemplate 은 Java에서 제공하는 서버 간 전송 시스템
        RestTemplate restTemplate = new RestTemplate();

        // postForEntity 는 서버에 데이터를 전송하고 데이터를 수신하는 역할을 함
        ResponseEntity<T> tResponseEntity = restTemplate.postForEntity(uri, requestsMessage, resp);

        // if 문을 통해 httpStatus 상태를 확인하고 HttpStatus.OK(Http 상태 코드가 정상(code: 200)) 가 되면
        // postForEntity 로 부터 받은 Body(데이터)를 반환
        if (!tResponseEntity.getStatusCode().equals(HttpStatus.OK)) {
            throw new RuntimeException("서버 간 통신 에러 발생 = "+ tResponseEntity);
        }
        return tResponseEntity.getBody();
    }
}
