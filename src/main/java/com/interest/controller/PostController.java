package com.interest.controller;

import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostCreateResult;
import com.interest.dto.CommonResponseDto;
import com.interest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {
    private final PostService postService;

    @PostMapping // Generic wildcard ? 사용 (모든 타입 허용)
    public ResponseEntity<CommonResponseDto<?>> savePost(PostCreateRequestDto requestDto){
        PostCreateResult response = postService.save(requestDto);

        return ResponseEntity.ok(
                CommonResponseDto.builder()
                        .success(true)
                        .data(response)
                        .build()
        );
    }
}
