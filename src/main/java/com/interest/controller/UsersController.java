package com.interest.controller;

import com.interest.domain.Users;
import com.interest.dto.CommonResponseDto;
import com.interest.dto.UsersCreateRequestDto;
import com.interest.dto.UsersCreateResult;
import com.interest.service.UsersService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "유저 API")
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@RestController
public class UsersController {
    private final UsersService usersService;

    @PostMapping
    public ResponseEntity<CommonResponseDto<UsersCreateResult>> userEnroll(UsersCreateRequestDto requestDto){
        UsersCreateResult result = usersService.save(requestDto);

        return ResponseEntity.ok(new CommonResponseDto<>(
                true,
                result
        ));
    }
}
