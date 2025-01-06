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
        Gender gender=null;

        switch (request.gender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;

        }

        return Member.builder()
                .address(request.address())
                .specAddress(request.specAddress())
                .gender(gender)
                .name(request.name())
                .memberPrefers(new ArrayList<>())
                .build();
    }
}
