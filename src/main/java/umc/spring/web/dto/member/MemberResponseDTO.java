package umc.spring.web.dto.member;

import java.time.LocalDateTime;
import lombok.Builder;

public record MemberResponseDTO() {

    @Builder
    public record JoinResultDTO(
        Long memberId,
        LocalDateTime createdAt
    ){}
}
