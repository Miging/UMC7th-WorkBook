package umc.spring.web.dto.review;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record ReviewRequestDTO() {
    //TODO: 1. 등록된 멤버인지 확인
    public record RegisterDTO(
            @NotBlank(message = "멤버 ID는 필수입니다.")
            Long memberId,
            @NotBlank(message = "리뷰 내용은 필수입니다.")
            String body,
            @Max(value = 5, message = "리뷰 점수는 5점을 넘을 수 없습니다.")
            @Min(value = 0, message = "리뷰 점수는 0점 미만일 수 없습니다.")
            Float score
    ){

    }
}
