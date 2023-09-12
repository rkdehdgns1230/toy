package com.interest.controller;

import com.interest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class PageController {
    private final PostService postService;

    @GetMapping("/post-list")
    public String getMainPage(){
        return "post_list";
    }
}
