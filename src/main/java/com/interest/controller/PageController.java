package com.interest.controller;

import com.interest.domain.Post;
import com.interest.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class PageController {
    private final PostService postService;

    @GetMapping("/post-list")
    public String getMainPage(Model model){
        List<Post> postList = postService.findAll();
        model.addAttribute("postList", postList);
        return "post_list";
    }

    @GetMapping("/post")
    public String getWritePage(){
        return "write";
    }
}
