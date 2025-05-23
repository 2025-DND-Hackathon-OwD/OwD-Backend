package site.owd.docs;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DocsTestController implements CommonControllerDocs{

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
        @PathVariable Long memberId
    ) {
        return "delete api: " + memberId;
    }
}
