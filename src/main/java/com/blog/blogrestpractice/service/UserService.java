package com.blog.blogrestpractice.service;

import com.blog.blogrestpractice.config.auth.PrincipalDetail;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.domain.user.UserRepository;
import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public Long update(User user, PrincipalDetail principalDetail) {
        User userEntity = userRepository.findById(user.getId());
        userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()), user.getNickname());
        principalDetail.setUser(userEntity);
        return userEntity.getId();
    }
}
