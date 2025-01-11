package umc.spring.web.dto.member;

import java.util.Collections;
import java.util.List;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import umc.spring.domain.enums.Role;
import umc.spring.validation.annotation.ExistCategories;

public record MemberRequestDTO() {

	public record JoinDto(
		@NotBlank
		String name,
		@NotBlank
		@Email
		String email,
		@NotBlank
		String password,
		@NotNull
		Integer gender,
		@NotNull
		Integer birthYear,
		@NotNull
		Integer birthMonth,
		@NotNull
		Integer birthDay,
		@Size(min = 5, max = 12)
		String address,
		@Size(min = 5, max = 12)
		String specAddress,
		@ExistCategories
		List<Long> preferCategory,
		@NotNull
		Role role
	) {
		// 빈 객체를 나타내는 상수
		public static final JoinDto EMPTY = new JoinDto(
			"",
			"",
			"",
			0,
			0,
			1,
			1,
			"",
			"",
			Collections.emptyList(),
			null
		);
	}
}
