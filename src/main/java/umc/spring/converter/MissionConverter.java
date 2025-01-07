package umc.spring.converter;

import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.web.dto.mission.MissionRequestDTO.AddDTO;
import umc.spring.web.dto.mission.MissionResponseDTO.RegisterResultDTO;

public class MissionConverter {

    public static Mission toEntity(AddDTO request, Store store) {
        return Mission.builder()
                .store(store)
                .missionSpec(request.missionSpec())
                .reward(request.reward())
                .deadLine(request.deadline())
                .build();
    }

    public static RegisterResultDTO toRegisterResultDTO(Mission mission) {
        return RegisterResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(mission.getCreatedAt())
                .build();
    }
}
