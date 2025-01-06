package umc.spring.web.dto.mission;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.time.LocalDateTime;

public record MissionRequestDTO() {
    public record RegisterDTO(
            @NotBlank(message = "마감날짜는 필수 입력값입니다.")
            LocalDateTime deadline,
            @Min(value = 0, message = "보상은 0 이상의 값이어야 합니다.")
            Integer reward,
            @NotBlank(message = "미션 내용은 필수 입력값입니다.")
            String missionSpec
    ){
    }
}
