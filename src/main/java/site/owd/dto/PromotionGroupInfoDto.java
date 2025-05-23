package site.owd.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import site.owd.entity.StoreCategory;

@Getter
@AllArgsConstructor
public class PromotionGroupInfoDto {

    private String storeName;
    private StoreCategory category;
    private String address;
    private String image;
    private int promotion_rate;
    private double distance;

}
