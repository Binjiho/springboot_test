package org.spring.study01.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.entity.MemberEntity;
import org.spring.study01.project.repository.MemberRepository;
import org.spring.study01.project.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public int memberInsert(MemberDto memberDto) {

        //save 함수는 Entity 객체만 가능
        //memberRepository.save(memberDto);

        //Dto -> Entity 변환
        MemberEntity memberEntity = new MemberEntity().builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .htel(memberDto.getHtel())
                .build();

        memberRepository.save(memberEntity);

        return 0;
    }
}
