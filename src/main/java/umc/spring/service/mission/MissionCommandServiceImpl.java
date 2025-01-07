package umc.spring.service.mission;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.ReviewException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.mission.MissionRequestDTO.AddDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

    private final StoreRepository storeRepository;

    private final MissionRepository missionRepository;

    @Override
    @Transactional
    public Mission registerMission(Long storeId, AddDTO request) {
        Store store=storeRepository.findById(storeId).orElseThrow(()->new ReviewException(ErrorStatus.STORE_NOT_FOUND));
        Mission newMission= MissionConverter.toEntity(request,store);
        return missionRepository.save(newMission);
    }
}
