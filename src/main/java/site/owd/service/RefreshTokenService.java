package site.owd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.owd.entity.RefreshToken;
import site.owd.repository.RefreshTokenRepository;

@Service
@RequiredArgsConstructor
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshToken findByRefreshToken(String refreshToken) {
        return refreshTokenRepository.findByRefreshToken(refreshToken)
            .orElseThrow(() -> new IllegalArgumentException("Unexpected token"));
    }
}
