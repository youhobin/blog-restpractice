package com.blog.blogrestpractice.service;

import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.domain.user.UserRepository;
import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long save(UserSaveRequestDto userSaveRequestDto) {
        User user = userSaveRequestDto.toEntity();
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.encodePassword(hashPw);
        return userRepository.save(user);
    }
}
