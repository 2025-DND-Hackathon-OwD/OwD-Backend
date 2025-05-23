package site.owd.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.owd.common.exception.CustomException;
import site.owd.dto.PromotionGroupInfoDto;
import site.owd.dto.SearchStoreDto;
import site.owd.entity.Store;
import site.owd.exception.StoreExceptionCode;
import site.owd.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreRepository storeRepository;

    public List<SearchStoreDto> searchStore(String keyword) {

        List<Store> getSearchStore = storeRepository.findStoreByKeyword(keyword);

        return getSearchStore.stream()
            .map(SearchStoreDto::from)
            .collect(Collectors.toList());
    }

    public PromotionGroupInfoDto getPromotionGroupInfo(Long storeId) {
        Store store = storeRepository.findById(storeId)
            .orElseThrow(() -> new CustomException(StoreExceptionCode.STORE_NOT_FOUND));

        double randomDistance = Math.round((Math.random() * 5.0) * 100.0) / 100.0;

        return new PromotionGroupInfoDto(
            store.getName(),
            store.getCategory(),
            store.getAddress(),
            store.getImage(),
            store.getPromotionRate(),
            randomDistance
        );
    }
}
