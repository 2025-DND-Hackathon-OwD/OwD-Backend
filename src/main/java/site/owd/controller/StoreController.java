package site.owd.controller;

import static org.springframework.http.HttpStatus.CREATED;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.owd.common.response.ApiResponse;
import site.owd.common.response.SuccessCode;
import site.owd.dto.CommentRequestDto;
import site.owd.dto.CommentResponseDto;
import site.owd.dto.PromotionGroupInfoDto;
import site.owd.dto.SearchStoreDto;
import site.owd.service.StoreService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;


    // 가게 검색
    @PostMapping("/search")
    public ResponseEntity<ApiResponse<List<SearchStoreDto>>> searchStore(
        @RequestParam String keyword
    ) {
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(ApiResponse.success(StoreSuccessCode.GET_SEARCH_STORE,storeService.searchStore(keyword)));
    }

    @GetMapping("/{storeId}")
    public ResponseEntity<ApiResponse<PromotionGroupInfoDto>> getStoreInfo(
        @PathVariable Long storeId
    ) {
        PromotionGroupInfoDto result = storeService.getPromotionGroupInfo(storeId);
        return ResponseEntity.ok(ApiResponse.success(StoreSuccessCode.STORE_FOUND, result));
    }

    @PostMapping("/{storeId}/promotion-request")
    public ResponseEntity<ApiResponse<Void>> requestPromotion(
        @PathVariable Long storeId,
        @RequestBody CommentRequestDto request
    ) {

        storeService.writeComment(storeId, request);
        return ResponseEntity.status(CREATED)
            .body(ApiResponse.success(StoreSuccessCode.STORE_FOUND));
    }

    @GetMapping("/{storeId}/promotion-request")
    public ResponseEntity<ApiResponse<List<CommentResponseDto>>> getComments(
        @PathVariable Long storeId
    ) {
        List<CommentResponseDto> result = storeService.getCommentsByStoreId(storeId);
        return ResponseEntity.ok(
            ApiResponse.success(new SuccessCode() {
                @Override public String getCode() { return "STORE_04"; }
                @Override public String getMessage() { return "제휴 요청에 성공했습니다."; }
            }, result)
        );
    }
}
