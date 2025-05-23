package site.owd.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import site.owd.common.exception.ExceptionCode;

@Getter
@RequiredArgsConstructor
public enum StoreExceptionCode implements ExceptionCode {
    STORE_NOT_FOUND(HttpStatus.NOT_FOUND, "S01", "해당 가게를 찾을 수 없습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
