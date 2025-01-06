package umc.spring.repository.review;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;

@Repository
@Transactional(readOnly = true)
public interface ReviewRepository extends JpaRepository<Review,Long>,ReviewRepositoryCustom {
}
