package com.mung.square.dto;

import lombok.Getter;
import lombok.ToString;


@Getter
@ToString

// 카카오에게 값을 전달하는 DTO 객체
// paymentContent 에서 받은 데이터는 카카오가 사용하는 변수명으로 매칭시켜 준다.
// 사용자에게 받는 데이터 외에 꼭 설정해야하는 데이터가 존재함
// => approval_url(승인 시 페이지), cancel_url(취소 시 페이지), fail_url(실패 시 페이지)
public class KakaopayReqVo {
    private String cid;
    private String partner_order_id;
    private String partner_user_id;
    private String item_name;
    private Integer quantity;
    private Integer total_amount;
    private Integer tax_free_amount;
    private String approval_url;
    private String cancel_url;
    private String fail_url;

    public KakaopayReqVo(String cid, String receiveUrl, KakaopayReq kakaopayReq) {
        this.cid = cid;
        this.partner_order_id = kakaopayReq.getOrdId();
        this.partner_user_id = kakaopayReq.getUserId();
        this.item_name = kakaopayReq.getItemNm();
        this.quantity = kakaopayReq.getQuantity();
        this.total_amount = kakaopayReq.getItemAmt();
        this.tax_free_amount = kakaopayReq.getFreeAmt();
        this.approval_url = receiveUrl;
        this.cancel_url = receiveUrl;
        this.fail_url = receiveUrl;
    }
}

