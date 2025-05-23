package site.owd.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import site.owd.common.response.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum StoreSuccessCode implements SuccessCode {
    GET_SEARCH_STORE("STORE_02", "가게 검색에 성공했습니다."),
    ;

    private final String code;
    private final String message;

}
