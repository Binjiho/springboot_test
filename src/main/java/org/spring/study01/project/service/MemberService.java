package org.spring.study01.project.service;

import org.spring.study01.project.dto.MemberDto;

import java.util.List;

public interface MemberService {
    int memberInsert(MemberDto memberDto);

   MemberDto memberDetail(Long userId);

   List<MemberDto> getMemberList();
}
