package com.mung.square.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateForm {
    private String name;
    private int totalPrice;
}
