package com.interest.service;

import com.interest.domain.Users;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.dto.UsersCreateResult;
import com.interest.exception.CustomException;
import com.interest.exception.ExceptionMessage;
import com.interest.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsersServiceImpl implements UsersService{
    private final UsersRepository usersRepository;

    @Override
    public UsersCreateResult save(UsersCreateRequestDto requestDto) {
        Users users = usersRepository.save(Users.builder()
                .email(requestDto.getEmail())
                .password(requestDto.getPassword())
                .userName(requestDto.getUserName())
                .build());

        return new UsersCreateResult(
                users.getId(),
                users.getEmail(),
                users.getPassword(),
                users.getUserName()
        );
    }

    @Override
    public Users findById(Long id) {
        return usersRepository.findById(id).orElseThrow(
                        () -> new CustomException(ExceptionMessage.POST_ID_INVALID)
        );
    }
}
