package umc.spring.apipayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import umc.spring.apipayload.code.BaseErrorCode;
import umc.spring.apipayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    //일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"COMMON500","서버에러,관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN,"COMMON403","금지된 요청입니다."),

    //멤버관리 에러
    MEMBER_NOT_FOUND(HttpStatus.BAD_REQUEST,"MEMBER4001","멤버를 찾을 수 없습니다."),
    NICKNAME_NOT_EXIST(HttpStatus.BAD_REQUEST,"MEMBER4002","닉네임은 필수입니다."),

    //이외 에러
    ARTICLE_NOT_FOUND(HttpStatus.NOT_FOUND,"ARTICLE4001","게시글이 없습니다."),

    //음식 카테고리 에러
    FOOD_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND,"CATEGORY4001","해당 음식 카테고리를 찾을 수 없습니다."),

    //지역 에러
    REGION_NOT_FOUND(HttpStatus.NOT_FOUND,"REGION4001","해당 지역을 찾을 수 없습니다."),

    //가게 에러
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND,"STORE4001","해당 가게를 찾을 수 없습니다."),

    //미션 에러
    MISSION_NOT_FOUND(HttpStatus.NOT_FOUND,"MISSION4001","해당 미션을 찾을 수 없습니다."),
    MISSION_ALREADY_CHALLENGED(HttpStatus.BAD_REQUEST,"MISSION4002","이미 도전한 미션입니다."),

    TEMP_EXCEPTION(HttpStatus.BAD_REQUEST,"TEMP4001","테스트 에러입니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .code(code)
                .message(message)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}
