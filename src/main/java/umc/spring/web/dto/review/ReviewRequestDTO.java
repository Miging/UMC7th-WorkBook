package umc.spring.web.dto.review;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Schema(description = "리뷰 등록 요청 DTO")
public record ReviewRequestDTO() {

    @Schema(description = "리뷰 등록 서브 DTO")
    public record RegisterDTO(

            @Schema(description = "멤버 ID", example = "1")
            @NotBlank(message = "멤버 ID는 필수입니다.")
            Long memberId,

            @Schema(description = "리뷰 내용", example = "매우 만족스러웠습니다!")
            @NotBlank(message = "리뷰 내용은 필수입니다.")
            String body,

            @Schema(description = "리뷰 점수 (0~5)", example = "4.5")
            @Max(value = 5, message = "리뷰 점수는 5점을 넘을 수 없습니다.")
            @Min(value = 0, message = "리뷰 점수는 0점 미만일 수 없습니다.")
            Float score
    ) {
    }
}
