package org.spring.study01.project.repository;

import org.spring.study01.project.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Repository : DAO
 */
public interface MemberRepository extends JpaRepository<MemberEntity,Long> {
//    @Override
//    List<MemberEntity> findAll();
}
