package umc.spring.repository.MissionRepository;

import java.util.List;
import umc.spring.domain.Mission;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByMemberIdAndStatus(Long id, int status, int page);

    List<Mission> findMissionsByMemberIdAndRegionId(Long member_id, Long region_id, int page);

}
