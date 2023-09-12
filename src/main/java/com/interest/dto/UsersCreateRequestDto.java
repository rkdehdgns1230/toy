package com.interest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UsersCreateRequestDto {
    private final String email;
    private final String password; //TODO: 비밀번호 암호화 로직 구현 필요
    private final String userName;
}
