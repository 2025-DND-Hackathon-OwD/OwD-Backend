package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.MemberParticipation;

public interface MemberParticipationRepository extends JpaRepository<MemberParticipation, Long> {
}
