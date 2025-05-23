package site.owd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.owd.entity.RefreshToken;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByRefreshToken(String refreshToken);
}
