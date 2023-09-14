package com.interest.service;

import com.interest.domain.Users;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.dto.UsersCreateResult;

public interface UsersService {
    UsersCreateResult save(UsersCreateRequestDto requestDto);
    Users findById(Long id);
}
