package com.mung.square.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// 카카오페이 요청에 대한 답을 보내는 정보를 담는 객체

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KakaopayAuthResVo {
    private String tid;
    private String next_redirect_mobile_url;
    private String next_redirect_pc_url;
    private LocalDateTime created_at;
}
