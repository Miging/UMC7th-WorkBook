package umc.spring.service.ReviewService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.repository.MemberRepository;
import umc.spring.repository.ReviewRepository.ReviewRepository;
import umc.spring.repository.StoreRepository.StoreRepository;

@Service
@RequiredArgsConstructor
@Transactional()
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
        System.out.println("created review: "+createdReview);
        return createdReview;
    }
}
