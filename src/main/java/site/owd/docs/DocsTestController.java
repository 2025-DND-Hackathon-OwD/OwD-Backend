package site.owd.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Test API")
@RestController
public class DocsTestController {

    @Operation(summary = "test get api")
    @ApiResponse(responseCode = "404", description = "올바르지 않은 경로입니다.")
    @GetMapping("/api/get-api")
    public GetApiDto getApi() {
        final GetApiDto dto = new GetApiDto(
            "test",
            12,
            "test.gmail",
            "010-0000-0000",
            "test address"
        );
        return dto;
    }

    @PostMapping("/api/post-api")
    public String postApi(
        @RequestBody PostApiDto dto
    ) {
        return "post api: " + dto.name();
    }

    @DeleteMapping("/api/delete-api/{memberId}")
    public String deleteApi(
        @RequestParam Long memberId
    ) {
        return "delete api: " + memberId;
    }
}
