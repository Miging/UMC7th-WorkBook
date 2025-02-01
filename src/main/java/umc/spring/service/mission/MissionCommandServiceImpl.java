package umc.spring.service.mission;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.ReviewException;
import umc.spring.converter.MissionConverter;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.member.MemberRepository;
import umc.spring.repository.membermission.MemberMissionRepository;
import umc.spring.repository.mission.MissionRepository;
import umc.spring.repository.store.StoreRepository;
import umc.spring.web.dto.mission.MissionRequestDTO.AddDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService {

	private final StoreRepository storeRepository;

	private final MissionRepository missionRepository;

	private final MemberRepository memberRepository;

	private final MemberMissionRepository memberMissionRepository;

	@Override
	@Transactional
	public Mission registerMission(Long storeId, AddDTO request) {
		Store store = storeRepository.findById(storeId)
			.orElseThrow(() -> new ReviewException(ErrorStatus.STORE_NOT_FOUND));
		Mission newMission = MissionConverter.toEntity(request, store);
		return missionRepository.save(newMission);
	}

	@Override
	@Transactional
	public MemberMission challengeMission(Long storeId, Long missionId, Long memberId) {
		Mission mission = missionRepository.findById(missionId)
			.orElseThrow(() -> new ReviewException(ErrorStatus.MISSION_NOT_FOUND));
		Member member = memberRepository.findById(memberId)
			.orElseThrow(() -> new ReviewException(ErrorStatus.MEMBER_NOT_FOUND));
		memberMissionRepository.findByMissionAndMember(mission, member)
			.ifPresent(memberMission -> {
				throw new ReviewException(ErrorStatus.MISSION_ALREADY_CHALLENGED);
			});

		return memberMissionRepository.save(MemberMission.builder()
			.mission(mission)
			.member(member)
			.build());
	}
}
