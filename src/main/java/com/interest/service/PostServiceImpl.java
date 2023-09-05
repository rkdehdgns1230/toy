package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
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
    public Post save(PostCreateRequestDto requestDto) {
        validate(requestDto);

        return postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .password(requestDto.getPassword())
                .build());
    }

    private void validate(PostCreateRequestDto requestDto){
        if(requestDto.getTitle().length() >= 10){
            throw new CustomException(ExceptionMessage.POST_TITLE_LENGTH_TOO_LONG);
        }
        if(requestDto.getContent().length() >= 50){
            throw new CustomException(ExceptionMessage.POST_CONTENT_LENGTH_TOO_LONG);
        }
    }
}
