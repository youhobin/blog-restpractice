package com.blog.blogrestpractice.controller.api;

import com.blog.blogrestpractice.config.auth.PrincipalDetail;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import com.blog.blogrestpractice.dto.user.UserUpdateRequestDto;
import com.blog.blogrestpractice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserApiController {

    private final UserService userService;

    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.save(userSaveRequestDto);
    }

    @PutMapping("/api/v1/user")
    public Long update(@RequestBody UserUpdateRequestDto userUpdateRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return userService.update(userUpdateRequestDto, principalDetail);
    }
}
