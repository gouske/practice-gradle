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
            // (24, 27) 람다 -> 메서드 참조로 변경
            .csrf(org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer::disable)
            // (25, 63) 람다 -> 메서드 참조로 변경
            .headers(headers -> headers.frameOptions(org.springframework.security.config.annotation.web.configurers.HeadersConfigurer.FrameOptionsConfig::disable))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/users/**", "/h2-console/**").permitAll()
                .anyRequest().authenticated()
            );

        return http.build();
    }
}