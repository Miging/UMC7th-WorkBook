package umc.spring.service.mission;

import jakarta.validation.Valid;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.mission.MissionRequestDTO;

public interface MissionCommandService {

    Mission registerMission(Long storeId, @Valid MissionRequestDTO.AddDTO request);

    MemberMission challengeMission(Long storeId, Long missionId, Long memberId);
}
