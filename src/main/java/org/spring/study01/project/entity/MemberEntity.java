package org.spring.study01.project.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.spring.study01.project.dto.MemberDto;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @Entity = DB테이블과 매핑
 */
@Table(name = "member_test")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class MemberEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name="user_pw", length = 255, nullable = false)
    private String userPw;

    @Column(length = 100, nullable = false)
    private String htel;

    @Column(length = 1, columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer grade;

    @Column(name = "delete_yn", length = 1, columnDefinition = "tinyint(1) ")
    @ColumnDefault("0")
    private Integer deleteYn;

    @CreationTimestamp // 자동으로 시간 설정
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @Column(name = "modified_date")
    private LocalDateTime modifiedDate;

}
