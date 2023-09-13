package com.interest.controller;

import com.interest.exception.CustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice // 모든 컨트롤러에서 발생하는 예외를 잡는다.
public class ExceptionController {

    // 모든 CustomException에 대해서 공통 처리 (400 Bad Request client error 처리)
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> BadRequestException(final CustomException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

}
