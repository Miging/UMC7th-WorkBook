package umc.spring.web.dto.mission;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;

public record MissionRequestDTO() {
    
    public record AddDTO(
            @Schema(description = "미션 설명", example = "3잔 구매시 할인")
            @NotBlank(message = "미션 내용은 필수 입력값입니다.")
            String missionSpec,

            @Schema(description = "보상 포인트", example = "500")
            @Min(value = 0, message = "보상은 0 이상의 값이어야 합니다.")
            Integer reward,

            @Schema(description = "마감 날짜", example = "2025-01-10T23:59:59")
            @NotNull(message = "마감 날짜는 필수 입력값입니다.")
            LocalDateTime deadline
    ) {
    }
}
