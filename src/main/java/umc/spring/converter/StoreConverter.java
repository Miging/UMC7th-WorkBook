package umc.spring.converter;

import java.util.ArrayList;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO.registerDTO;
import umc.spring.web.dto.store.StoreResponseDTO.RegisterResultDTO;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class StoreConverter {
    public static Store toEntity(registerDTO request, Region region){
        return Store.builder()
                .name(request.name())
                .address(request.address())
                .region(region)
                .reviews(new ArrayList<>())
                .build();
    }

    public static RegisterResultDTO toRegisterResultDTO(Store store) {
        return RegisterResultDTO.builder()
                .storeId(store.getId())
                .createdAt(store.getCreatedAt())
                .build();
    }
}
