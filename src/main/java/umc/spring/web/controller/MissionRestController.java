package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apipayload.ApiResponse;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Mission;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.mission.MissionCommandService;
import umc.spring.web.dto.mission.MissionRequestDTO;
import umc.spring.web.dto.mission.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/stores")
public class MissionRestController {

    private final MissionCommandService missionService;

    @PostMapping("/{storeId}/missions")
    @Operation(summary = "가게 미션 등록", description = "특정 매장에 미션을 등록합니다.")
    public ApiResponse<MissionResponseDTO.RegisterResultDTO> registerMission(@Parameter(description = "매장 ID", required = true) @PathVariable("storeId") Long storeId, @RequestBody @Valid MissionRequestDTO.AddDTO request) {
        Mission mission=missionService.registerMission(storeId, request);
        return ApiResponse.onSuccess(MissionConverter.toRegisterResultDTO(mission));
    }

    @GetMapping("/{storeId}/missions/{missionId}/challenge/{memberId}")
    @Operation(summary = "미션 도전", description = "특정 매장의 미션을 도전합니다.")
    public ApiResponse<MissionResponseDTO.ChallengeResultDTO> challengeMission(@Parameter(description = "매장 ID", required = true) @PathVariable("storeId") Long storeId, @Parameter(description = "미션 ID", required = true) @PathVariable("missionId") Long missionId, @Parameter(description = "회원 ID", required = true) @PathVariable("memberId") Long memberId) {
        MemberMission challengedMission=missionService.challengeMission(storeId, missionId, memberId);
        return ApiResponse.onSuccess(MissionConverter.toChallengeResultDTO(challengedMission));
    }
}
