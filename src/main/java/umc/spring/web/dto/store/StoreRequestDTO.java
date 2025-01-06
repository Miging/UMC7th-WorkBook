package umc.spring.web.dto.store;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import umc.spring.validation.annotation.ExistRegion;

public record StoreRequestDTO() {

    //TODO: 상점 이름/주소 DB와 중복되는지 확인하는 validation 추가
    public record registerDTO(
            @NotBlank(message = "상점 이름은 필수 입력 값입니다.")
            String name,
            @ExistRegion
            Long regionId,
            @Size(min = 5,max = 40,message = "주소는 5자 이상 40자 이하로 입력해주세요.")
            String address
    ){}
}
