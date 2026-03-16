package com.example.practicegradle.service;

import com.example.practicegradle.domain.User;
import com.example.practicegradle.dto.UserRequestDto;
import com.example.practicegradle.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
// 서비스 계층에서의 암호화 예시
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@Service // (1) "이 클래스는 비즈니스 로직을 수행하는 서비스야!"
@RequiredArgsConstructor // (2) final이 붙은 필드를 이용해 생성자를 자동으로 만들어줘요 (의존성 주입)
public class UserService {

    private final UserRepository userRepository; // (3) 서비스는 금고 관리자(Repository)가 필요해요.
    // BCrypt 암호화 도구 생성
    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    /**
     * 회원 가입 (저장)
     */
//    @Transactional // (4) 데이터베이스를 건드리는 작업은 안전하게 '트랜잭션' 처리가 필요해요.
//    public User join(User user) {
//        // 실무라면 여기서 "이미 가입된 이메일인가?" 같은 검증 로직이 들어갑니다.
//        return userRepository.save(user);
//    }
    @Transactional
    public User join(UserRequestDto userRequestDto){
        // 1. 비밀번호 암호화 수행 (평문 -> 암호문)
        String encodedPassword = passwordEncoder.encode(userRequestDto.password());

        // 2. DTO -> Entity 변환
        User user = new User();
        user.setLoginId(userRequestDto.loginId());
        user.setPassword(encodedPassword); // 암호화된 비번 저장
        user.setName(userRequestDto.name());
        user.setEmail(userRequestDto.email());
        user.setPhoneNumber(userRequestDto.phoneNumber());

        // 3. DB 저장
        return userRepository.save(user);
    }

    /**
     * 전체 회원 조회
     */
    @Transactional(readOnly = true) // (5) 읽기 전용 작업은 성능을 위해 옵션을 줄 수 있어요.
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }
}
