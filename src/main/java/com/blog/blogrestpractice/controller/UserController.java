package com.blog.blogrestpractice.controller;

import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/auth/user/save")
    public String userSave(Model model) {
        model.addAttribute("userSaveRequestDto", new UserSaveRequestDto());
        return "layout/user/user-save";
    }

    @GetMapping("/auth/user/login")
    public String userLogin() {
        return "layout/user/user-login";
    }
}
