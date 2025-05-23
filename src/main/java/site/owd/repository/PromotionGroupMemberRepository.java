package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.PromotionGroupMember;

public interface PromotionGroupMemberRepository extends JpaRepository<PromotionGroupMember, Long> {
}
