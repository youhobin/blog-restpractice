package com.blog.blogrestpractice.service;

import com.blog.blogrestpractice.config.auth.PrincipalDetail;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.domain.user.UserRepository;
import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import com.blog.blogrestpractice.dto.user.UserUpdateRequestDto;
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
    public Long update(UserUpdateRequestDto userUpdateRequestDto, PrincipalDetail principalDetail) {
        User userEntity = userRepository.findById(userUpdateRequestDto.getId());
        String updatePassword = userUpdateRequestDto.getPassword();
        String updateNickname = userUpdateRequestDto.getNickname();
        userEntity.update(bCryptPasswordEncoder.encode(updatePassword), updateNickname);
        principalDetail.setUser(userEntity);
        return userEntity.getId();
    }
}
