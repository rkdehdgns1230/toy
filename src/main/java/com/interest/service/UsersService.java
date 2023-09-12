package com.interest.service;

import com.interest.domain.Users;
import com.interest.dto.UsersCreateRequestDto;

public interface UsersService {
    Users save(UsersCreateRequestDto requestDto);
}
