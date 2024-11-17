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
    public List<Mission> findMissionsByMemberIdAndStatus(Long memberId,int status) {
        List<Mission> missions=missionRepository.findMissionsByMemberIdAndStatus(memberId,status,1);
        String str=status==1?"ongoing":"completed";
        missions.forEach(mission -> System.out.println(str+" mission: "+mission));
        return missions;
    }
}
