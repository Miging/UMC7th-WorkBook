package umc.spring.config.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import umc.spring.domain.Member;
import umc.spring.repository.member.MemberRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService {

	private final MemberRepository memberRepository;

	/*
		1. 사용자 폼 제출
		2. Security가 UserDetailService의 loadUserByUsername호출(DB조회)
		3.존재한다면 User 객체 반환
		4. 이 User는 Security가 인증을 수행하는데 필요
	 */
	//유저 객체를 반환함
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = memberRepository.findByEmail(username)
			.orElseThrow(() -> new UsernameNotFoundException("해당 이메일을 가진 유저가 존재하지 않습니다"));
		log.info("loadUserByUsername: " + member.getName());

		//user details 객체
		return User
			.withUsername(member.getEmail())
			.password(member.getPassword())
			.roles(member.getRole().name())
			.build();

	}
}
