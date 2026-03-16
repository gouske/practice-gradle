package com.example.practicegradle.dto;

// class
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter @Setter
//public class UserResponseDto {
//    private Long id;            // 고유 식별 번호
//    private String loginId;
//    private String name;
//    private String email;
//    // 비밀번호와 전화번호는 개인정보 보호를 위해 제외하거나 마스킹 처리합니다.
//}

// record
public record UserResponseDto(
        Long id,
        String loginId,
        String name,
        String email
) {
}