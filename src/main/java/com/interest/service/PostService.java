package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostUpdateRequestDto;

public interface PostService {
    Post save(PostCreateRequestDto requestDto);
    Post update(PostUpdateRequestDto requestDto);

    Post findById(Long id);
}
