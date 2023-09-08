package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostUpdateRequestDto;
import com.interest.exception.CustomException;
import com.interest.exception.ExceptionMessage;
import com.interest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;

    @Override
    @Transactional
    public Post save(PostCreateRequestDto requestDto) { //TODO: ResponseDto로 반환하도록 변경
        return postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .password(requestDto.getPassword())
                .build());
    }

    @Override
    @Transactional
    public Post update(PostUpdateRequestDto requestDto) { //TODO: ResponseDto로 반환하도록 변경

        Post post = postRepository.findById(requestDto.getId())
                .orElseThrow(() -> new CustomException(ExceptionMessage.POST_ID_INVALID));

        post.update(requestDto);
        return post;
    }


}
