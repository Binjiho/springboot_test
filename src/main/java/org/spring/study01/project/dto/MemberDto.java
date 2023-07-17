package org.spring.study01.project.dto;

import lombok.*;

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
}
