package com.interest.controller;

import com.interest.dto.PostCreateRequestDto;
import com.interest.dto.PostCreateResult;
import com.interest.dto.CommonResponseDto;
import com.interest.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "게시글 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
@RestController
public class PostController {
    private final PostService postService;

    @Operation(summary = "게시글 작성", description = "게시글을 작성합니다.")
    @PostMapping // Generic wildcard ? 사용 (모든 타입 허용)
    public ResponseEntity<CommonResponseDto<PostCreateResult>> savePost(PostCreateRequestDto requestDto){
        PostCreateResult result = postService.save(requestDto);

        return ResponseEntity.ok(
                new CommonResponseDto<>(
                        true,
                        result
                )
        );
    }
}
