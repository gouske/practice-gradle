package com.example.practicegradle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // (1) 설정 파일임을 나타내는 스티커
@EnableWebSecurity // (2) 스프링 시큐리티 기능을 활성화!
public class SecurityConfig {

    // (3) BCryptPasswordEncoder를 'Bean'으로 등록하여 어디서든 빌려 쓰게 함
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    // (4) 핵심 보안 설정 (누구를 통과시킬 것인가?)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // 실무 API 서버는 보통 CSRF를 비활성화함 (Postman 테스트를 위해 필수)
            .headers(headers -> headers.frameOptions(frame -> frame.disable())) // H2 콘솔(iframe) 접속을 위해 필요
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**", "/h2-console/**").permitAll() // 회원가입, DB콘솔은 누구나 통과!
                .anyRequest().authenticated() // 그 외 나머지 모든 요청은 로그인이 필요함
            );

        return http.build();
    }
}