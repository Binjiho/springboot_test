package org.spring.study01.project.dto;

import lombok.*;
import org.spring.study01.project.entity.MemberEntity;

import java.lang.reflect.Member;
import java.time.LocalDateTime;


/**
 * DTO(client -> controller -> service )
 * JPA(repository -> entity -> db)
 * DTO : Client -> Controller -> Service -> Repository -> Entity -> DB
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MemberDto {

    private Long id;
    private String userId;
    private String userPw;
    private String htel;
    private Integer grade;
    private Integer deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;
    
    //Entity->Dto

    // 1.회원가입
    public static MemberEntity toMemberEntity(MemberDto memberDto){
        MemberEntity memberEntity = MemberEntity.builder()
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .htel(memberDto.getHtel())
                .build();
        return memberEntity;
    }
    // 2.회원수정
    public static MemberEntity toMemberUpdateEntity(MemberDto memberDto){
        MemberEntity memberEntity =        MemberEntity.builder()
                .id(memberDto.getId())
                .userId(memberDto.getUserId())
                .userPw(memberDto.getUserPw())
                .htel(memberDto.getHtel())
                .build();
        return memberEntity;
    }
    // 3.회원목록조회
    // 4.회원상세조회
}
