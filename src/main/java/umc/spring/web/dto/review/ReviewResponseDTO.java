package umc.spring.web.dto.review;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Builder;

public record ReviewResponseDTO() {

    @Builder
    public record RegisterResultDTO(
        Long reviewId,
        Long memberId,
        Long storeId,
        LocalDateTime createdAt
    ){}

    @Builder
    public record ReviewPreViewListDTO(
            List<ReviewPreviewDTO> reviewList,
            Integer listSize,
            Integer totalPage,
            Long totalElements,
            Boolean isFirst,
            Boolean isLast
    ){}

    @Builder
    public record ReviewPreviewDTO(
            String ownerNickname,//작성자 정보, 추후 객체로 확장 가능성
            Float score,
            String body,
            LocalDate createAt
    ){}

}
