package com.mung.square.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

// PaymentContent에서 전달한 데이터를 받기 위한 DTO 객체
public class KakaopayReq {
    private String ordId;
    private String userId;
    private String itemNm;
    private int quantity;
    private int itemAmt;
    private int freeAmt;
}
