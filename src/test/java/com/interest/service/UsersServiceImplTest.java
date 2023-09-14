package com.interest.service;

import com.interest.domain.Users;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.dto.UsersCreateResult;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class UsersServiceImplTest {

    @Autowired
    UsersService usersService;

    private static final String TEST_EMAIL = "test@email.com";
    private static final String TEST_PASSWORD = "password";
    private static final String TEST_USERNAME = "testUser";

    @Test
    void users_생성_성공(){
        //given
        //when
        UsersCreateResult result = usersService.save(new UsersCreateRequestDto(
                TEST_EMAIL,
                TEST_PASSWORD,
                TEST_USERNAME
        ));

        //then
        assertThat(result.getEmail()).isEqualTo(TEST_EMAIL);
        assertThat(result.getPassword()).isEqualTo(TEST_PASSWORD);
        assertThat(result.getUserName()).isEqualTo(TEST_USERNAME);
    }

}