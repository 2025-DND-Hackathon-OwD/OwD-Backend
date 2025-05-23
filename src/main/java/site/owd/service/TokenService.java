package site.owd.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.owd.common.exception.CustomException;
import site.owd.common.jwt.TokenProvider;
import site.owd.dto.LoginDto;
import site.owd.dto.TokenResponseDto;
import site.owd.entity.Member;
import site.owd.exception.TokenExceptionCode;
import site.owd.repository.MemberRepository;

import java.time.Duration;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenProvider tokenProvider;
    private final RefreshTokenService refreshTokenService;
    private final MemberRepository memberRepository;

    public String createNewAccessToken(String refreshToken) {
        if(!tokenProvider.validToken(refreshToken)) {
            throw new CustomException(TokenExceptionCode.INVALID_REFRESH_TOKEN);
        }

        Long userId = refreshTokenService.findByRefreshToken(refreshToken).getMember().getId();
        Member member = memberRepository.findById(userId).orElseThrow();

        return tokenProvider.generateToken(member, Duration.ofHours(1));
    }

    public TokenResponseDto generateAccessToken(LoginDto loginDto) {
        Member member = memberRepository.findByNameAndEmail(loginDto.getName(), loginDto.getEmail())
            .orElseThrow(() -> new CustomException(TokenExceptionCode.MEMBER_NOT_FOUND));

        String token = tokenProvider.generateToken(member, Duration.ofHours(5));
        return new TokenResponseDto(token);
    }
}
