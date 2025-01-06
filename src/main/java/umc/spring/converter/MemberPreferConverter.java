package umc.spring.converter;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.FoodCategory;
import umc.spring.domain.mapping.MemberPrefer;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class MemberPreferConverter {

    public static MemberPrefer toMemberPrefer(FoodCategory category) {
        return MemberPrefer.builder()
                .foodCategory(category)
                .build();
    }
}
