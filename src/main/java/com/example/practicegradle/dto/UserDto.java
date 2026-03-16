package com.example.practicegradle.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private String name;
    private String email;

    // 엔티티를 DTO로 변환하는 생성자나 메서드를 두기도 합니다.
}