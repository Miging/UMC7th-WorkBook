package umc.spring.service.review;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.review.ReviewRepository;
import umc.spring.repository.store.StoreRepository;

@Service
@RequiredArgsConstructor
@Slf4j
//안티패턴?
public class ReviewQueryServiceImpl implements ReviewQueryService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Override
    public Review addReview(Long memberId, Long storeId, Float score, String body) {
        Member member= memberRepository.findById(memberId).orElse(null);
        Store store= storeRepository.findById(memberId).orElse(null);

        Review review=new Review();
        review.setMember(member);
        review.setStore(store);
        review.setScore(score);
        review.setBody(body);

        Review createdReview=reviewRepository.save(review);
        log.debug("created review: {}", createdReview);
        return createdReview;
    }

    @Override
    public Page<Review> getReviewList(Long storeId, Integer page) {
        Store store=storeRepository.findById(storeId).get();

        Page<Review> storePage=reviewRepository.findAllByStore(store, PageRequest.of(page,10));
        return storePage;
    }
}
