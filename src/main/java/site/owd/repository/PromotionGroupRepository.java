package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.PromotionGroup;

public interface PromotionGroupRepository extends JpaRepository<PromotionGroup, Long> {
}
