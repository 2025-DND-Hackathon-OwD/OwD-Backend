package site.owd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.owd.common.response.ApiResponse;
import site.owd.dto.CreatePromotionGroupDto;
import site.owd.service.PromotionService;

import static site.owd.controller.PromotionGroupSuccessCode.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PromotionController {

    private final PromotionService promotionService;

    @GetMapping("/promotion")
    public ResponseEntity<ApiResponse<CreatePromotionGroupDto>> getRandomPromotions() {
        CreatePromotionGroupDto result = promotionService.createPromotionGroup();
        return ResponseEntity.ok(ApiResponse.success(GET_PROMOTION_GROUPS, result));
    }

}
