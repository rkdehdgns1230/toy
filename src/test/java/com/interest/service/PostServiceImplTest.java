package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostCreateResult;
import com.interest.dto.PostUpdateRequestDto;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.exception.CustomException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;
    @Autowired
    UsersService usersService;

    private static final String TEST_TITLE = "test_title";
    private static final String TEST_TITLE_OVER_FLOW = "test test test test test";
    private static final String TEST_CONTENT = "test_content";
    private static final String TEST_PASSWORD = "password";
    private static final Long TEST_USER_ID = 1L;
    private static final String TEST_EMAIL = "test@email.com";
    private static final String TEST_USERNAME = "testUser";
    @BeforeEach
    void init() {
        usersService.save(new UsersCreateRequestDto(
                TEST_EMAIL,
                TEST_PASSWORD,
                TEST_USERNAME
        ));
    }

    @Test
    void post_생성_성공(){
        //given
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                TEST_TITLE,
                TEST_CONTENT,
                TEST_PASSWORD,
                TEST_USER_ID
        );

        //when
        PostCreateResult result = postService.save(requestDto);

        //then
        assertThat(result.getTitle()).isEqualTo(TEST_TITLE);
        assertThat(result.getContent()).isEqualTo(TEST_CONTENT);
        assertThat(result.getPassword()).isEqualTo(TEST_PASSWORD);
    }

    @Test
    void post_생성_실패_제목_글자수_초과(){
        //given
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                TEST_TITLE_OVER_FLOW,
                TEST_CONTENT,
                TEST_PASSWORD,
                TEST_USER_ID
        );

        //when
        //then
        assertThrows(CustomException.class, () -> postService.save(requestDto));
    }

    @Test
    void post_업데이트_성공(){
        //given
        final String UPDATE_TITLE = "update title";
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                UPDATE_TITLE,
                TEST_CONTENT,
                TEST_PASSWORD,
                TEST_USER_ID
        );
        PostCreateResult result = postService.save(requestDto);
        Post post = postService.findById(result.getId());
        LocalDateTime currentLastModifiedAt = post.getLastModifiedAt();

        //when
        postService.update(new PostUpdateRequestDto(
                post.getId(),
                UPDATE_TITLE,
                requestDto.getContent(),
                requestDto.getPassword()
        ));
        Post findPost = postService.findById(post.getId());

        //then
        assertThat(findPost.getTitle()).isEqualTo(UPDATE_TITLE);
        assertThat(findPost.getLastModifiedAt()).isAfter(currentLastModifiedAt);
    }
}