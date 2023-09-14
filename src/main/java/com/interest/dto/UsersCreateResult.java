package com.interest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UsersCreateResult {
    private final Long id;
    private final String email;
    private final String password;
    private final String userName;
}
