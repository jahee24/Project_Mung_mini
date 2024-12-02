package com.mung.square.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateForm {
    private int resvNum;
    private String name;
    private int totalPrice;
}
