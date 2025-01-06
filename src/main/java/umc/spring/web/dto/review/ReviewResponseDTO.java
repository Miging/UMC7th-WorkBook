package umc.spring.web.dto.review;

import java.time.LocalDateTime;
import lombok.Builder;

public record ReviewResponseDTO() {

    @Builder
    public record RegisterResultDTO(
        Long reviewId,
        Long memberId,
        Long storeId,
        LocalDateTime createdAt
    ){}
}
