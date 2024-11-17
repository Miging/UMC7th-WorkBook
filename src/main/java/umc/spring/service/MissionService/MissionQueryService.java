package umc.spring.service.MissionService;

import java.util.List;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    List<Mission> findMissionsByMemberIdAndStatus(Long memberId, int status);
}
