package umc.spring.service.review;

import jakarta.validation.Valid;
import umc.spring.domain.Review;
import umc.spring.web.dto.review.ReviewRequestDTO.RegisterDTO;

public interface ReviewCommandService {

    Review registerReview(Long storeId, @Valid RegisterDTO request);
}
