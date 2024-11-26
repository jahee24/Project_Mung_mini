package com.mung.square.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("mymap")
public class MapDTO {
    private String branchName;
    private String address;
    private String branchTel;
    private String latitude;
    private String longitude;
    private int parkingAvailable;
    private Timestamp openingHours;
    private Timestamp closingHours;
 }
