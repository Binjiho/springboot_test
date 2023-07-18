package org.spring.study01.member;

import org.junit.jupiter.api.Test;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.entity.MemberEntity;
import org.spring.study01.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.text.html.Option;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void insertTest(){
        MemberEntity memberEntity = new MemberEntity().builder()
                .userId("test01")
                .userPw("1234")
                .htel("010-test-0000")
                .build();

        Long member_id = memberRepository.save(memberEntity).getId();

        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(member_id);
        if(memberEntityOptional.isPresent()) {
            System.out.println("회원가입성공");
        }else{
            System.out.println("회원가입 실패");
        }
    }

    @Test
    void MemberDetail(){
        Optional<MemberEntity> memberEntityOptional = memberRepository.findById(100L);

        if(memberEntityOptional.isPresent()){
            System.out.println("회원존재");
        }else{
            System.out.println("회원존재X");
        }
    }

    @Test
    void MemberList(){
        List<MemberDto> memberDtoList = new ArrayList<>();
        List<MemberEntity> memberEntityList = memberRepository.findAll();
        for (MemberEntity memberEntity: memberEntityList){
            MemberDto memberDto = MemberDto.builder()
                    .id(memberEntity.getId())
                    .build();
        }

    }
}
