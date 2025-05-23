package site.owd.controller;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class MemberController {

/*    @PostMapping("/login")
    public ResponseEntity<TokenResponseDto> issueAccessToken(@RequestBody LoginDto loginDto) {
        TokenResponseDto response = tokenService.generateAccessToken(loginDto);
        return ResponseEntity.ok(response);
    }*/

/*    @PostMapping("/role/{role}")
    public ResponseEntity<HttpStatus> saveRole(@RequestParam("role") String role) {

    }*/
}
