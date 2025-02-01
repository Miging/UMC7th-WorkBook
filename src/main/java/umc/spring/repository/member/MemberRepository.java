package umc.spring.repository.member;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import umc.spring.domain.Member;
import umc.spring.domain.enums.MemberStatus;

public interface MemberRepository extends JpaRepository<Member, Long> {

	//1. 메서드이름으로 쿼리생성
	//    List<Member> findByNameAndStatus(String name, MemberStatus status);

	//2.@Query 어노테이션으로
	@Query("SELECT m from Member m where m.name = :name AND m.status=:status")
	List<Member> findByNameAndStatus(@Param("name") String name, @Param("status") MemberStatus status);

	Optional<Member> findByEmail(String email);
}
