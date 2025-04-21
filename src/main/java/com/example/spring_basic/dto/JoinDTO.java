package com.example.spring_basic.dto;

import lombok.*;

//lombok라이브러리로부터 아래 어노테이션을 활성화 시키면
//매번 동일한 getter, setter, 생성자함수, 반환값 문자열 변환을 실행할 필요 없음
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class JoinDTO {
    private String uname;
    private String email;
    private String colors;
}
