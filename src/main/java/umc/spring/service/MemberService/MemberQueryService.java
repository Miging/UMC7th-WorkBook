package umc.spring.service.MemberService;

import java.util.Optional;
import umc.spring.domain.Member;
import umc.spring.domain.Store;

public interface MemberQueryService {
    //유저정보(닉네임,이메일,휴대폰,포인트)를 조회하는 메소드
    Optional<Member> findMember(Long id);


}
