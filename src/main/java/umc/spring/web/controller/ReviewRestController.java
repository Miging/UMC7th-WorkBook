package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewService;

    @Operation(summary = "리뷰 등록", description = "특정 매장에 리뷰를 등록합니다.")
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.RegisterResultDTO> registerReview(@Parameter(description = "매장 ID", required = true) @PathVariable("storeId") Long storeId, @RequestBody @Valid ReviewRequestDTO.RegisterDTO request) {
        Review review=reviewService.registerReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toRegisterResultDTO(review));
    }
}
