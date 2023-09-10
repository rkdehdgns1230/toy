package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostUpdateRequestDto;
import com.interest.exception.CustomException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;

    private static final String TEST_TITLE = "test_title";
    private static final String TEST_TITLE_OVER_FLOW = "test test test test test";
    private static final String TEST_CONTENT = "test_content";
    private static final String TEST_PASSWORD = "test_password";


    @Test
    void post_생성_성공(){
        //given
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                TEST_TITLE,
                TEST_CONTENT,
                TEST_PASSWORD
        );

        //when
        Post post = postService.save(requestDto);

        //then
        assertThat(post.getTitle()).isEqualTo(TEST_TITLE);
        assertThat(post.getContent()).isEqualTo(TEST_CONTENT);
        assertThat(post.getPassword()).isEqualTo(TEST_PASSWORD);
    }

    @Test
    void post_생성_실패_제목_글자수_초과(){
        //given
        PostCreateRequestDto requestDto = new PostCreateRequestDto(
                TEST_TITLE_OVER_FLOW,
                TEST_CONTENT,
                TEST_PASSWORD
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
                TEST_PASSWORD
        );
        Post post = postService.save(requestDto);

        //when
        post.update(new PostUpdateRequestDto(
                post.getId(),
                UPDATE_TITLE,
                requestDto.getContent(),
                requestDto.getPassword()
        ));
        Post findPost = postService.findById(post.getId());

        //then
        assertThat(findPost.getTitle()).isEqualTo(UPDATE_TITLE);
    }
}