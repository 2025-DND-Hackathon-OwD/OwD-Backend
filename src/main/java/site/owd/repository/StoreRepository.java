package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}
