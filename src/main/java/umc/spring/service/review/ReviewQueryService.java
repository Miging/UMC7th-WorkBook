package umc.spring.service.review;

import org.springframework.data.domain.Page;
import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review addReview(Long memberId, Long storeId, Float score , String body);
    Page<Review> getReviewList(Long storeId, Integer page);
}
