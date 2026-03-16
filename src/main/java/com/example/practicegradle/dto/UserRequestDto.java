package com.example.practicegradle.dto;

// class
//import lombok.Getter;
//import lombok.Setter;
//
//@Getter @Setter
//public class UserRequestDto {
//    private String loginId;     // 아이디
//    private String password;    // 비밀번호 (입력받음)
//    private String name;        // 이름
//    private String email;       // 이메일
//    private String phoneNumber; // 전화번호
//}

// record
public record UserRequestDto(
        String loginId,
        String password,
        String name,
        String email,
        String phoneNumber
) {}