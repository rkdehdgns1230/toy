package com.interest.repository;

import com.interest.domain.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.*;

@SpringBootTest
class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Test
    void post_생성_성공(){
        //given
        Post post = Post.builder()
                .title("안녕")
                .content("안녕하십니까?")
                .password("1324")
                .build();

        //when
        postRepository.save(post);
        Post findPost = postRepository.findById(post.getId())
                .orElseThrow(IllegalStateException::new);

        //then
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getContent()).isEqualTo(post.getContent());
        assertThat(findPost.getPassword()).isEqualTo(post.getPassword());

        assertThat(findPost.getId()).isNotNull();
        assertThat(findPost.getCreatedAt()).isNotNull();
        assertThat(findPost.getLastModifiedAt()).isNotNull();
    }
}