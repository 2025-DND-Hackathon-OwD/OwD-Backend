package site.owd.docs;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Test API")
public interface CommonControllerDocs {

    @Operation(summary = "test get api")
    @ApiResponse(responseCode = "404", description = "올바르지 않은 경로입니다.")
    GetApiDto getApi();

    @Operation(summary = "test post api")
    String postApi(PostApiDto dto);

    @Operation(summary = "test delete api")
    String deleteApi(Long memberId);
}
