package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

public interface ReviewQueryService {
    Review addReview(Long memberId, Long storeId, Float score , String body);

}
