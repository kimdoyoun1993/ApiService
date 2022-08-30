package com.apiservice.model;

import lombok.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiDTO {

    public interface insertGroup{}
    public interface updateGroup{}


    private Integer memberNumber; //사용자 번호

    @NotEmpty(message = "아이디를 입력해주세요" , groups = insertGroup.class)
    @Email(message = "ID 는 Email 형식으로 입력해주세요" , groups = updateGroup.class)
    private String memberId; // 사용자 ID

    @NotEmpty(message = "비밀번호를 입력해주세요", groups = insertGroup.class)
    private String memberPw; // 사용자 PW

    @NotEmpty(message = "이름을 입력해주세요" , groups = insertGroup.class)
    private String memberName; // 사용자 이름

    @Pattern(regexp = "(\\d{2,3})-?(\\d{3,4})-?(\\d{4})$",message = "휴대폰 번호를 다시 확인해주세요 ",groups = {insertGroup.class,updateGroup.class})
    private String memberPhone; // 사용자 휴대폰 번호

    @Pattern(regexp ="N|Y",message = "광고 수신은 Y 거부는 N 를 입력해주세요 ",groups = {insertGroup.class,updateGroup.class})
    private String advert; // 광고 수신


    private LocalDateTime regDate;

    private LocalDateTime updateDate;

    private int deviceCount; // device 등록


}
