package com.apiservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DeviceDTO {


    private Integer serviceNumber; // 서비스 번호

    @NotEmpty(message = "장치 넘버를 입력해 주세요")
    private String deviceName;  // 장치 이름

    @NotEmpty(message = "장치 종류를 입력해 주세요")
    private String deviceType;  // 장치 종류

    @NotEmpty(message = "설치 기사 이름을 입력해 주세요")
    private String installer;   // 설치 기사

    @NotEmpty(message = "지역을 입력해 주세요")
    private String region; // 지역

    private LocalDateTime inDate; // 설치 날짜


    private Integer memberNumber; // 고객 번호

}
