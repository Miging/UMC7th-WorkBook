package umc.spring.repository.review;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Review;
import umc.spring.domain.Store;

@Repository
@Transactional(readOnly = true)
public interface ReviewRepository extends JpaRepository<Review,Long>,ReviewRepositoryCustom {
    Page<Review> findAllByStore(Store store, PageRequest pageRequest);
}
