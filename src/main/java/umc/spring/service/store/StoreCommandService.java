package umc.spring.service.store;

import jakarta.validation.Valid;
import umc.spring.domain.Store;
import umc.spring.web.dto.store.StoreRequestDTO;

public interface StoreCommandService {

    Store registerStore(@Valid StoreRequestDTO.registerDTO request);
}
