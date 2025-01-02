package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Mission> findMissionsByMemberIdAndStatus(Long id,int status,int page) {
        //모든 미션
        QMission mission = QMission.mission;
        //멤버가 참여한 미션
        QMemberMission memberMission=QMemberMission.memberMission;
        MissionStatus missionStatus=status==1?MissionStatus.CHALLENGING:MissionStatus.COMPLETE;

        return queryFactory
                .select(memberMission.mission)
                .from(memberMission)
                .where(memberMission.member.id.eq(id))
                .where(memberMission.status.eq(missionStatus))
                .limit(15)
                .offset((page-1)*15)
                .fetch();
    }

    @Override
    public List<Mission> findMissionsByMemberIdAndRegionId(Long member_id, Long region_id,
                                                                    int page) {
        QMission mission = QMission.mission;
        QMemberMission memberMission=QMemberMission.memberMission;
        //현재 지역에서 아직 member_mission에 등록되지 않은 미션들
        return queryFactory
                .selectFrom(mission)
                .where(mission.store.region.id.eq(region_id))
                .where(mission.id.notIn(
                        JPAExpressions
                                .select(memberMission.mission.id)
                                .from(memberMission)
                                .where(memberMission.member.id.eq(member_id))
                )).fetch();

    }
}
