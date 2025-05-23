package site.owd.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import site.owd.common.response.SuccessCode;

@Getter
@RequiredArgsConstructor
public enum PromotionGroupSuccessCode implements SuccessCode {
    GET_PROMOTION_GROUPS("PROMOTION_01", "제휴 그룹들을 조회하였습니다.");

    private final String code;
    private final String message;
}