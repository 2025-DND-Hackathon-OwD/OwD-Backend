package site.owd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CreatePromotionGroupDto {
    private List<PromotionGroupDto> promotionGroups;
}