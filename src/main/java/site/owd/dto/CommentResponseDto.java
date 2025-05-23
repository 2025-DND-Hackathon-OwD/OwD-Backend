package site.owd.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CommentResponseDto {
    private String storeName;
    private String comment;
    private LocalDateTime createAt;
}
