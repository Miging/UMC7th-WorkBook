package umc.spring.service.MissionService;

import java.util.List;
import umc.spring.domain.Mission;

public interface MissionQueryService {
    List<Mission> findStoresByMemberId(Long memberId);
}
