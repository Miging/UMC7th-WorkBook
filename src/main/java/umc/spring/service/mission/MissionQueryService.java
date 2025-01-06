package umc.spring.service.mission;

import java.util.List;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    List<Mission> findMissionsByMemberIdAndStatus(Long memberId, int status);
    List<Mission> findMissionsByMemberIdAndRegionId(Long memberId, Long regionId);
}
