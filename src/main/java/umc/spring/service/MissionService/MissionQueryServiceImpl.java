package umc.spring.service.MissionService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {
    private final MissionRepository missionRepository;
    @Override
    public List<Mission> findStoresByMemberId(Long memberId) {
        List<Mission> missions=missionRepository.findMissionsByMemberId(memberId,1);
        missions.forEach(mission -> System.out.println("mission: "+mission));
        return missions;
    }
}
