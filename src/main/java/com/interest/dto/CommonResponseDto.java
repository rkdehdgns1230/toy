package com.interest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class CommonResponseDto<T> {
    private boolean success;
    private T data;

    @Builder
    public CommonResponseDto(boolean success, T data) {
        this.success = success;
        this.data = data;
    }
}
