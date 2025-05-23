package site.owd.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.owd.dto.LoginDto;
import site.owd.dto.TokenResponseDto;
import site.owd.service.TokenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

    private final TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> issueAccessToken(@RequestBody LoginDto loginDto) {
        TokenResponseDto response = tokenService.generateAccessToken(loginDto);
        return ResponseEntity.ok(response);
    }
/*
    @PostMapping("/role/{role}")
    public ResponseEntity<HttpStatus> saveRole(, @RequestParam("role") String role) {

    }*/
}
