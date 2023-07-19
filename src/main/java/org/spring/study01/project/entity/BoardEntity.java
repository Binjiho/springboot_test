package org.spring.study01.project.entity;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Table(name = "test_board2") //기존에 생성되어있는 테이블
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "title", length = 100, nullable = false)
    private String title;

    @Column(name="content", length = 255, nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name= "writer", length = 100, nullable = false)
    private String writer;

    @Column(length = 1)
    @ColumnDefault("0")
    private Integer view_cnt;

    @Column(name = "notice_yn", length = 1, nullable = false, columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer noticeYn;

    @Column(name = "delete_yn", length = 1, nullable = false, columnDefinition = "tinyint(1)")
    @ColumnDefault("0")
    private Integer deleteYn;

    @CreationTimestamp // 자동으로 시간 설정
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @UpdateTimestamp
    @Column(name = "modified_date", insertable = false)
    private LocalDateTime modifiedDate;

    // N:1
    @ManyToOne
    @JoinColumn(name = "id", insertable = false, updatable = false)
    private MemberEntity memberEntity;
}
