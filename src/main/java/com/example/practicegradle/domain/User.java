package com.example.practicegradle.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity // (1) "이 클래스는 DB 테이블과 1:1로 매핑되는 객체야!"
@Getter // (2) 모든 필드의 get 메서드를 자동으로 생성해줘요.
@Setter // (3) 모든 필드의 set 메서드를 자동으로 생성해줘요.
@Table(name = "users") // DB에는 'users'라는 이름의 테이블로 저장될 거예요.
public class User {

    @Id // (4) PK (Primary Key, 기본키)임을 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 번호를 자동으로 1, 2, 3... 채워줘요.
    private Long id;

    @Column(nullable = false, length = 16)
    private String loginId;

    @Column(nullable = false, length = 16)
    private String password;

//    @Column(nullable = false) // (5) 이 컬럼은 비어있으면 안 돼요!
    @Column(nullable = false, unique = true, length = 50) // (5) 이 컬럼은 비어있으면 안 되고 길이는 50자 제한!
    private String name;

    private String email;

    @Column(length = 32)
    private String phoneNumber;
}
