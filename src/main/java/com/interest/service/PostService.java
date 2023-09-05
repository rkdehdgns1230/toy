package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;

public interface PostService {
    Post save(PostCreateRequestDto requestDto);
}
