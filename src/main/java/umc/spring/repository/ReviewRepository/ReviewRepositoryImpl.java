package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

//@Repository
//@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom{

//    private final JPAQueryFactory queryFactory;

//        @Override
//        public Review addReview(Long memberId, Long storeId, Float score, String body){
//            QReview review=QReview.review;
//
//
//            long executeResult=queryFactory
//                    .insert(review)
//                    .set(review.member.id, memberId)
//                    .set(review.store.id, storeId)
//                    .set(review.score, score)
//                    .set(review.body, body)
//                    .execute();
//
//            if(executeResult>0){
//                return queryFactory
//                        .select(review)
//                        .where(review.member.id.eq(memberId))
//                        .where(review.store.id.eq(storeId))
//                        .fetchOne();
//            }
//            return null;
//        }
}
