package umc.spring.web.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MemberConverter;
import umc.spring.domain.Member;
import umc.spring.service.member.MemberCommandService;
import umc.spring.web.dto.member.MemberRequestDTO.JoinDto;
import umc.spring.web.dto.member.MemberResponseDTO.JoinResultDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {

	private final MemberCommandService memberCommandService;

	@PostMapping
	public ApiResponse<JoinResultDTO> join(@RequestBody @Valid JoinDto request) {
		Member member = memberCommandService.joinMember(request);
		return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
	}
}
