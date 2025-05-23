package site.owd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class PromotionGroupDto {
    private Long promotionGroupId;
    private String promotionTitle;
    private List<PromotionGroupInfoDto> promotionGroup;
}