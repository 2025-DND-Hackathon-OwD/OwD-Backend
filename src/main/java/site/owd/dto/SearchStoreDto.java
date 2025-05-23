package site.owd.dto;

import site.owd.entity.PromotionStatus;
import site.owd.entity.Store;

public record SearchStoreDto(
    Long storeId,
    String storeName,
    PromotionStatus promotionStatus,
    String image,
    Double distance
) {
    public static SearchStoreDto from(Store store) {
        return new SearchStoreDto(
            store.getId(),
            store.getName(),
            store.getPromotionStatus(),
            store.getImage(),
            Math.round((Math.random() * 5.0) * 100.0) / 100.0
        );
    }
}
