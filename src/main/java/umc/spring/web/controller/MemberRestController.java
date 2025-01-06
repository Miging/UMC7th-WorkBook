package umc.spring.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.member.MemberCommandService;
import umc.spring.web.dto.member.MemberRequestDTO.JoinDto;
import umc.spring.web.dto.member.MemberResponseDTO.JoinResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberRestController {

    private final MemberCommandService memberCommandService;

    @PostMapping
    public ApiResponse<JoinResultDTO> join(@RequestBody @Valid JoinDto request) {
        Member member=memberCommandService.registerMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
