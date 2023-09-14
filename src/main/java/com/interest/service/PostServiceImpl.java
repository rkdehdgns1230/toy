package com.interest.service;

import com.interest.domain.Post;
import com.interest.domain.Users;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostCreateResult;
import com.interest.dto.PostUpdateRequestDto;
import com.interest.exception.CustomException;
import com.interest.exception.ExceptionMessage;
import com.interest.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class PostServiceImpl implements PostService{
    private final PostRepository postRepository;
    private final UsersService usersService;

    @Override
    @Transactional
    public PostCreateResult save(PostCreateRequestDto requestDto) { //TODO: ResponseDto로 반환하도록 변경
        Long userId = requestDto.getUserId();
        Users users = usersService.findById(userId);

        Post post = postRepository.save(Post.builder()
                .title(requestDto.getTitle())
                .content(requestDto.getContent())
                .password(requestDto.getPassword())
                .users(users)
                .build());
        return new PostCreateResult(
                post.getId(),
                post.getTitle(),
                post.getContent(),
                post.getPassword(),
                post.getViewCount()
        );
    }

    @Override
    @Transactional
    public Post update(PostUpdateRequestDto requestDto) { //TODO: ResponseDto로 반환하도록 변경
        Post post = findById(requestDto.getId());

        post.update(requestDto);
        return post;
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findById(id).orElseThrow(
                () -> new CustomException(ExceptionMessage.POST_ID_INVALID)
        );
    }

    @Override
    public List<Post> findAll() {
        return postRepository.findAll();
    }
}
