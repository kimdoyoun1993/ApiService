package com.apiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceVO {

    private Integer serviceNumber; // 서비스 번호
    private String deviceName;  // 장치 이름
    private String deviceType;  // 장치 종류
    private String installer;   // 설치 기사
    private String region; // 지역

    private LocalDateTime inDate; // 설치 날짜

    private Integer memberNumber; // 고객 번호

}
