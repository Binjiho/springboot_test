package org.spring.study01.project.dto;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.study01.project.entity.BoardEntity;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

    private Long id;
    private String title;
    private String content;
    private String writer;
    private Integer view_cnt;
    private Integer noticeYn;
    private Integer deleteYn;
    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;

    private List<BoardEntity> boardEntityList = new ArrayList<>();
}
