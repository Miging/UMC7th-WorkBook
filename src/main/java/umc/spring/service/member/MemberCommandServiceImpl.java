package umc.spring.service.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apipayload.code.status.ErrorStatus;
import umc.spring.apipayload.exception.handler.FoodCategoryException;
import umc.spring.converter.MemberConverter;
import umc.spring.converter.MemberPreferConverter;
import umc.spring.domain.Member;
import umc.spring.repository.foodcategory.FoodCategoryRepository;
import umc.spring.repository.member.MemberRepository;
import umc.spring.web.dto.member.MemberRequestDTO.JoinDto;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member registerMember(JoinDto request) {
        Member newMember = MemberConverter.toEntity(request);
        request.preferCategory()
                .stream()
                //요청 값의 카테고리 아이디로 카테고리를 찾아서 없으면 예외를 발생시킴
                .map(categoryId -> foodCategoryRepository.findById(categoryId).orElseThrow(()->new FoodCategoryException(
                        ErrorStatus.FOOD_CATEGORY_NOT_FOUND)))
                //찾은 카테고리를 MemberPrefer로 변환
                .map(MemberPreferConverter::toMemberPrefer)
                .forEach(memberPrefer -> memberPrefer.setMember(newMember));

        return memberRepository.save(newMember);
    }
}
