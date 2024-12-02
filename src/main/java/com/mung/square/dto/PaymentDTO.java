package com.mung.square.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("payment")
public class PaymentDTO {
    private String tid;
    private String userId;
    private String itemName;
    private int totalPrice;
    private int status;
    private int orderNum;
}
