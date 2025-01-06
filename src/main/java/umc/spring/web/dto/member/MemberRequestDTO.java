package umc.spring.web.dto.member;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.List;
import umc.spring.validation.annotation.ExistCategories;

public record MemberRequestDTO() {

    public record JoinDto(
            @NotBlank
            String name,
            @NotNull
            Integer gender,
            @NotNull
            Integer birthYear,
            @NotNull
            Integer birthMonth,
            @NotNull
            Integer birthDay,
            @Size(min = 5,max = 12)
            String address,
            @Size(min = 5,max = 12)
            String specAddress,
            @ExistCategories
            List<Long> preferCategory
    ){}
}
