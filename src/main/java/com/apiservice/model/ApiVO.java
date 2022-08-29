package com.apiservice.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ApiVO {

    private Integer memberNumber; //사용자 번호
    private String memberId; // 사용자 ID
    private String memberPw; // 사용자 PW
    private String memberName; // 사용자 이름
    private String memberPhone; // 사용자 휴대폰 번호
    private String advert; // 광고 수신
    private LocalDateTime regDate;
    private LocalDateTime updateDate;


}
