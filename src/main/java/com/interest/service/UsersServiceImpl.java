package com.interest.service;

import com.interest.domain.Users;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    @Override
    public Users save(UsersCreateRequestDto requestDto) {
        return usersRepository.save(Users.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .userName(requestDto.getUserName())
                .build());
    }
}
