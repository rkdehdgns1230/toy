package com.interest.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
@Schema
public class PostCreateRequestDto {
    @Schema(description = "게시글 제목", example = "테스트 제목")
    private final String title;
    @Schema(description = "게시글 내용", example = "게시글 작성 내용 테스트")
    private final String content;
    @Schema(description = "게시글 암호", example = "1234")
    private final String password;
    @Schema(description = "사용자 ID", example = "1")
    private final Long userId;
}
