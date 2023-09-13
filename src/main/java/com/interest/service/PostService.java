package com.interest.service;

import com.interest.domain.Post;
import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostCreateResult;
import com.interest.dto.PostUpdateRequestDto;

import java.util.List;

public interface PostService {
    PostCreateResult save(PostCreateRequestDto requestDto);
    Post update(PostUpdateRequestDto requestDto);
    Post findById(Long id);
    List<Post> findAll();
}
