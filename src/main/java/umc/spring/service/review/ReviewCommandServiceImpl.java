package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.ReviewException;
import umc.spring.converter.ReviewConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.review.ReviewRequestDTO.RegisterDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

    private final StoreRepository storeRepository;
    private final MemberRepository memberRepository;

    private final ReviewRepository reviewRepository;

    @Override
    @Transactional
    public Review registerReview(Long storeId, RegisterDTO request) {
        Store store=storeRepository.findById(storeId).orElseThrow(()->new ReviewException(ErrorStatus.STORE_NOT_FOUND));
        Member member=memberRepository.findById(request.memberId()).orElseThrow(()->new ReviewException(ErrorStatus.MEMBER_NOT_FOUND));
        Review newReview= ReviewConverter.toEntity(request,store,member);
        return reviewRepository.save(newReview);
    }
}
