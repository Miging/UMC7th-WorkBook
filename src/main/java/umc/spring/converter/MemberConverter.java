package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.enums.Gender;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberResponseDTO.JoinResultDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemberConverter {

	public static JoinResultDTO toJoinResultDTO(Member member) {
		return JoinResultDTO.builder()
			.memberId(member.getId())
			.createdAt(LocalDateTime.now())
			.build();
	}

	//DTO를 Entity로 변환
	public static Member toEntity(MemberRequestDTO.JoinDto request) {
		Gender gender = switch (request.gender()) {
			case 1 -> Gender.MALE;
			case 2 -> Gender.FEMALE;
			case 3 -> Gender.NONE;
			default -> null;
		};

		return Member.builder()
			.address(request.address())
			.specAddress(request.specAddress())
			.gender(gender)
			.name(request.name())
			.memberPrefers(new ArrayList<>())
			.email(request.email())
			.password(request.password())
			.role(request.role())
			.build();
	}
}
