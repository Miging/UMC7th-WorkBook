package umc.spring.web.dto.mission;

import java.time.LocalDateTime;
import lombok.Builder;

public record MissionResponseDTO() {

    @Builder
    public record RegisterResultDTO(
        Long missionId,
        LocalDateTime createdAt
    ){}
}
