package com.interest.repository;

import com.interest.domain.Users;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsersRepositoryTest {

    @Autowired
    UsersRepository usersRepository;

    @Test
    void users_객체_생성_성공(){
        //given
        Users users = Users.builder()
                .email("test@email.com")
                .userName("testUser")
                .password("passwd")
                .build();

        //when
        usersRepository.save(users);

        //then
        assertThat(users.getId()).isNotNull();
        assertThat(users.getCreatedAt()).isNotNull();
    }
}