package site.owd.controller;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.owd.common.response.ApiResponse;
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
}
