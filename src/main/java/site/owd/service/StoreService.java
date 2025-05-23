package site.owd.service;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.owd.dto.SearchStoreDto;
import site.owd.entity.Store;
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
}
