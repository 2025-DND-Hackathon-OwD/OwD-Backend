package site.owd.exception;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import site.owd.common.exception.ExceptionCode;

@Getter
@RequiredArgsConstructor
public enum TokenExceptionCode implements ExceptionCode {

    INVALID_REFRESH_TOKEN(HttpStatus.UNAUTHORIZED, "T01", "유효하지 않은 리프레시 토큰입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "T02", "해당 회원을 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
