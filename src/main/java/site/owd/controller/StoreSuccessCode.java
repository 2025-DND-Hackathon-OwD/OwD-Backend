package site.owd.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import site.owd.common.response.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum StoreSuccessCode implements SuccessCode {
    STORE_FOUND(HttpStatus.OK, "S01", "가게 정보를 성공적으로 조회했습니다."),
    GET_SEARCH_STORE(HttpStatus.CREATED, "STORE_02", "가게 검색에 성공했습니다.")
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;
}
