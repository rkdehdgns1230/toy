package com.interest.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class PostUpdateRequestDto {
    private final Long id;
    private final String title;
    private final String content;
    private final String password;
}
