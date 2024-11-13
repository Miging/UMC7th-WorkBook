package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.spring.domain.Mission;
import umc.spring.domain.QMember;
import umc.spring.domain.QMission;
import umc.spring.domain.mapping.QMemberMission;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl {

    private final JPAQueryFactory queryFactory;

    public List<Mission> findMissionsByMemberId(Long id,int page) {
        QMission mission = QMission.mission;
        QMemberMission memberMission=QMemberMission.memberMission;

        return queryFactory
                .selectFrom(mission)
                .where(mission.id.in(
                        JPAExpressions
                                .select(memberMission.id)
                                .from(memberMission)
                                .where(memberMission.member.id.eq(id))
                                .limit(15)
                                .offset((page-1)*15)
                ))
                .fetch();
    }
}
