package umc.spring.web.dto.review;

public record ReviewRequestDTO() {
    //TODO: 1. 등록된 멤버인지 확인
    public record RegisterDTO(
            Long memberId,
            String body,
            Float score
    ){

    }
}
