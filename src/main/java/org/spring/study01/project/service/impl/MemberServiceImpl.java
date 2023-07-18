package org.spring.study01.project.service.impl;

import lombok.RequiredArgsConstructor;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.entity.MemberEntity;
import org.spring.study01.project.repository.MemberRepository;
import org.spring.study01.project.service.MemberService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    @Transactional
    public int memberInsert(MemberDto memberDto) {

        //Dto -> Entity 변환
        MemberEntity memberEntity = new MemberEntity().builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .htel(memberDto.getHtel())
                .build();

        Long member_id = memberRepository.save(memberEntity).getId();

        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(member_id);
        if(memberEntityOptional.isPresent()) {
            System.out.println("회원가입성공");
            return 1;
        }else{
            System.out.println("회원가입 실패");
            return 0;
        }
    }

    @Override
    public MemberDto memberDetail(Long userId) {
        MemberDto memberDto = null;
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(userId);
        if(memberEntityOptional.isPresent()) {
            System.out.println("회원가입성공");
            memberDto= new MemberDto().builder().id(memberEntityOptional.get().getId())
                    .build();
        }else{
            System.out.println("회원가입 실패");
        }
        return memberDto;
    }

    @Override
    public List<MemberDto> getMemberList() {
        List<MemberDto> memberDtoList = new ArrayList<>();
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        for (MemberEntity memberEntity: memberEntityList){
            MemberDto memberDto = MemberDto.builder()
                    .id(memberEntity.getId())
                    .userId(memberEntity.getUserId())
                    .userPw(memberEntity.getUserPw())
                    .htel(memberEntity.getHtel())
                    .build();
            memberDtoList.add(memberDto);
        }
        return memberDtoList;
    }
}
