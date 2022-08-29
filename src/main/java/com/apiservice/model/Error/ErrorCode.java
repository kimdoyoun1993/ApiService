package com.apiservice.model.Error;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {

    BAD_REQUEST(400 ,"Bad Request"),
    BAD_ENTITY(401,"Bad ENTITY"),
    BAD_ARTICLE(404,"article value"),
    NOT_INFO(405,"없는 정보입니다"),
    SYS_ERR(500,"시스템 에러 입니다.");


    private final int status;
    private final String message;

    //  Enum 클래스로 사용할 에러들을 적어준다.
    //  status 값과 error message 만 프론트에 넘겨줄 예정으로 두 개만 작성하였다.
    //  재사용성을 생각해서 범위를 너무 좁게설정하지 말고 넓은 범위로 설정해보자
}
