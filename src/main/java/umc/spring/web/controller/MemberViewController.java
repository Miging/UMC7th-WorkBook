package umc.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import umc.spring.service.member.MemberCommandService;
import umc.spring.web.dto.member.MemberRequestDTO;
import umc.spring.web.dto.member.MemberRequestDTO.JoinDto;

@Controller
public class MemberViewController {

	private final MemberCommandService memberCommandService;

	public MemberViewController(MemberCommandService memberCommandService) {
		this.memberCommandService = memberCommandService;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/signup")
	public String signupPage(
		Model model) {
		model.addAttribute("memberJoinDto", JoinDto.EMPTY);
		return "signup";
	}

	@PostMapping("/members/signup")
	public String signupPage(@ModelAttribute("memberJoinDto") MemberRequestDTO.JoinDto request,
		//이거 requestbody로 개발시에는 하면 됨
		BindingResult bindingResult,//폼 데이터가 바인딩관 결과(바인딩 에러, 유효성 검증 에러등)이 들어있음
		Model model) {
		if (bindingResult.hasErrors()) {
			//해당 뷰에서 데이터 바인딩이 실패할경우 signup페이지를 유지함
			return "signup";
		}

		try {
			memberCommandService.joinMember(request);
			return "redirect:/login";
		} catch (Exception e) {
			//회원 가입시 에러일경우 에러 메세지 보내고 signup 페이지 유지
			model.addAttribute("error", e.getMessage());
			return "signup";
		}
	}

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
}
