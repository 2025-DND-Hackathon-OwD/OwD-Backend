package site.owd.repository;

import java.util.List;
import site.owd.entity.Store;

public interface StoreRepositoryCustom {
    List<Store> findStoreByKeyword(String keyword);
}
