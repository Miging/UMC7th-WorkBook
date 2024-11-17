package umc.spring.repository.MissionRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission,Long> {
    public List<Mission> findMissionsByMemberIdAndStatus(Long id, int status,int page);
}
