package umc.spring.service.member;

import jakarta.validation.Valid;
import umc.spring.domain.Member;
import umc.spring.web.dto.member.MemberRequestDTO.JoinDto;

public interface MemberCommandService {

    Member registerMember(@Valid JoinDto request);
}
