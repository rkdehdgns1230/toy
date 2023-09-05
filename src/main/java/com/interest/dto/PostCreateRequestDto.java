package com.interest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostCreateRequestDto {
    private final String title;
    private final String content;
    private final String password;
}
