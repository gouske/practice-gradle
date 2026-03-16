package com.example.practicegradle.controller;

import com.example.practicegradle.domain.User;
import com.example.practicegradle.service.UserService;
//import com.example.practicegradle.dto.UserDto;
import com.example.practicegradle.dto.UserRequestDto;
import com.example.practicegradle.dto.UserResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // (1) 데이터를 주고받는 API 전용 컨트롤러 스티커
@RequestMapping("/api/users") // (2) 이 컨트롤러의 모든 주소는 "/api/users"로 시작해요
@RequiredArgsConstructor // (3) 요리사(Service)를 불러오기 위한 생성자를 자동으로 만들어요
public class UserController {

    private final UserService userService; // 컨트롤러는 서비스가 필요해요

    /**
     * 회원 등록
     * POST http://localhost:8080/api/users
     */
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto){
        User savedUser = userService.join(userRequestDto);
        // 3. 결과를 다시 DTO로 변환하여 반환
//        UserResponseDto response = new UserResponseDto(
//                savedUser.getId(),
//                savedUser.getLoginId(),
//                savedUser.getName(),
//                savedUser.getEmail()
//        );
//
//        return response;
        return new UserResponseDto(
                savedUser.getId(),
                savedUser.getLoginId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }

//    @PostMapping
//    public UserResponseDto createUser(@RequestBody UserRequestDto userRequestDto) {
//        // 1. DTO를 엔티티로 변환 (보통 Service에서 처리함)
//        User user = new User();
//        user.setLoginId(userRequestDto.getLoginId());
//        user.setPassword(userRequestDto.getPassword());
//        user.setName(userRequestDto.getName());
//        user.setEmail(userRequestDto.getEmail());
//        user.setPhoneNumber(userRequestDto.getPhoneNumber());
//
//        // 2. 서비스 호출 및 저장
//        User savedUser = userService.join(user);
//
//        // 3. 결과를 다시 DTO로 변환하여 반환
//        UserResponseDto response = new UserResponseDto();
//        response.setId(savedUser.getId());
//        response.setLoginId(savedUser.getLoginId());
//        response.setName(savedUser.getName());
//        response.setEmail(savedUser.getEmail());
//
//        return response;
//    }

//    @PostMapping
//    public UserDto createUser(@RequestBody UserDto userDto) {
//        // 1. DTO를 엔티티로 변환 (보통 Service에서 처리함)
//        User user = new User();
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//
//        // 2. 서비스 호출 및 저장
//        User savedUser = userService.join(user);
//
//        // 3. 결과를 다시 DTO로 변환하여 반환
//        UserDto response = new UserDto();
//        response.setName(savedUser.getName());
//        response.setEmail(savedUser.getEmail());
//
//        return response;
//    }

//    @PostMapping // (4) 데이터를 생성(Create)할 때는 POST 방식을 사용해요
//    public User createUser(@RequestBody User user) {
//        // (5) @RequestBody는 보낸 데이터를 자바 객체로 변환해줘요
//        return userService.join(user);
//    }

    /**
     * 회원 전체 조회
     * GET http://localhost:8080/api/users
     */
    @GetMapping // (6) 데이터를 조회(Read)할 때는 GET 방식을 사용해요
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }
}