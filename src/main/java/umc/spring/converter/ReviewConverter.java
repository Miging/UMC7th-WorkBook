package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;
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

    public static ReviewResponseDTO.ReviewPreviewDTO toreviewPreviewDTO(Review review) {
        return ReviewResponseDTO.ReviewPreviewDTO.builder()
                .ownerNickname(review.getMember().getName())
                .score(review.getScore())
                .body(review.getBody())
                .createAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewResponseDTO.ReviewPreViewListDTO toreviewPreViewListDTO(Page<Review> reviews) {
        List<ReviewResponseDTO.ReviewPreviewDTO> reviewPreviewDTOs= reviews.stream()
                .map(ReviewConverter::toreviewPreviewDTO)
                .toList();

        return ReviewResponseDTO.ReviewPreViewListDTO.builder()
                .isLast(reviews.isLast())
                .isFirst(reviews.isFirst())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .listSize(reviewPreviewDTOs.size())
                .reviewList(reviewPreviewDTOs)
                .build();
    }
}
