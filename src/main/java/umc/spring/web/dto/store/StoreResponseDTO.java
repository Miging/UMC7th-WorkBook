package umc.spring.web.dto.store;

import java.time.LocalDateTime;
import lombok.Builder;

public record StoreResponseDTO() {

    @Builder
    public record RegisterResultDTO(
        Long storeId,
        LocalDateTime createdAt
    ){}
}
