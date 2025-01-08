package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Review;
import umc.spring.service.review.ReviewCommandService;
import umc.spring.service.review.ReviewQueryService;
import umc.spring.service.store.StoreQueryService;
import umc.spring.web.dto.review.ReviewRequestDTO;
import umc.spring.web.dto.review.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    private final ReviewQueryService reviewQueryService;

    private final StoreQueryService storeQueryService;

    @Operation(summary = "리뷰 등록", description = "특정 매장에 리뷰를 등록합니다.")
    @PostMapping("/{storeId}/reviews")
    public ApiResponse<ReviewResponseDTO.RegisterResultDTO> registerReview(@Parameter(description = "매장 ID", required = true) @PathVariable("storeId") Long storeId, @RequestBody @Valid ReviewRequestDTO.RegisterDTO request) {
        Review review= reviewCommandService.registerReview(storeId, request);
        return ApiResponse.onSuccess(ReviewConverter.toRegisterResultDTO(review));
    }

    @GetMapping("/{storeId}/reviews")
    @Operation(summary = "특정 가게의 리뷰 목록 조회 API", description = "특정 매장의 리뷰 미리보기 리스트를 조회하는 API이며,페이징을 포함합니다. query String을 통해 page 번호를 제공해주세요.")
    @ApiResponses({
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200", description = "성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰 없음",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "access 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "access 토큰 모양 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "storeId", description = "매장 ID, path variable", required = true),
    })
    public ApiResponse<ReviewResponseDTO.ReviewPreViewListDTO> getReviewPreViewList(@Parameter(description = "매장 ID", required = true) @PathVariable("storeId") Long storeId, @RequestParam(name = "page") Integer page) {
        Page<Review> reviews= reviewQueryService.getReviewList(storeId,page);
        return ApiResponse.onSuccess(ReviewConverter.toreviewPreViewListDTO(reviews));
    }
}
