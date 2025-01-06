package umc.spring.converter;

import java.time.LocalDateTime;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO.RegisterResultDTO;

public final class ReviewConverter {
    public static Review toEntity(ReviewRequestDTO.RegisterDTO request, Store store, Member member) {
        return Review.builder()
                .store(store)
                .score(request.score())
                .body(request.body())
                .member(member)
                .build();
    }

    public static RegisterResultDTO toRegisterResultDTO(Review review) {
        return RegisterResultDTO.builder()
                .reviewId(review.getId())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
