package com.blog.blogrestpractice.dto.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserUpdateRequestDto {

    private Long id;
    private String password;
    private String nickname;
}
