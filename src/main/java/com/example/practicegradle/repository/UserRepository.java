package com.example.practicegradle.repository;

import com.example.practicegradle.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // (1) "이 인터페이스는 DB에 접근하는 금고 관리자야!"
public interface UserRepository extends JpaRepository<User, Long> {
    // (2) 아무런 코드를 작성하지 않아도 기본적인 CRUD 기능을 사용할 수 있습니다.
}