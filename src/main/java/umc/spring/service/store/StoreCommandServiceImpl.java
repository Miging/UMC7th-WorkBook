package umc.spring.service.store;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.StoreException;
import umc.spring.converter.StoreConverter;
import umc.spring.domain.Region;
import umc.spring.domain.Store;
import umc.spring.repository.region.RegionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.store.StoreRequestDTO.registerDTO;

@Service
@RequiredArgsConstructor
public class StoreCommandServiceImpl implements StoreCommandService {

    private final RegionRepository regionRepository;

    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public Store registerStore(registerDTO request) {
        //request에서 regionID를 받아오고, region에 존재하는 region인지 확인.
        Region region=regionRepository.findById(request.regionId())
                .orElseThrow(() -> new StoreException(ErrorStatus.REGION_NOT_FOUND));
        Store newStore = StoreConverter.toEntity(request,region);
        return storeRepository.save(newStore);
    }
}
