package org.spring.study01;

import org.junit.jupiter.api.Test;
import org.spring.study01.project.dto.MemberDto;
import org.spring.study01.project.entity.MemberEntity;
import org.spring.study01.project.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Member;
import java.util.Optional;
import java.util.stream.IntStream;

@SpringBootTest
class Study01ApplicationTests {

	@Autowired
	MemberRepository memberRepository;

	@Test
	public void testClass(){
		System.out.println(memberRepository.getClass().getName());
	}

	@Test
	public void testInsertDummies(){
		IntStream.rangeClosed(1,100).forEach(i -> {
			MemberEntity memberEntity = MemberEntity.builder()		.userId("test"+i)
					.userPw("1234")
					.htel("01012345678")
					.build();
			memberRepository.save(memberEntity);
		});
	}

	@Test
	public void testSelect(){
		Long id = 100L;
		Optional<MemberEntity> result = memberRepository.findById(id);

		System.out.println("=========================");

		if(result.isPresent()){
			MemberEntity member = result.get();
			System.out.println(member);
		}
	}

	@Test
	public void testUpdate(){
		MemberEntity member = MemberEntity.builder()
				.id(100L)
				.userId("test100_update")
				.userPw("1234")
				.htel("011-1234-5678")
				.build();
		System.out.println(memberRepository.save(member));
	}


}
