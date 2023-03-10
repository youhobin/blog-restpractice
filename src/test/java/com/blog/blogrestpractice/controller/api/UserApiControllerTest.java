package com.blog.blogrestpractice.controller.api;

import com.blog.blogrestpractice.domain.user.Role;
import com.blog.blogrestpractice.domain.user.User;
import com.blog.blogrestpractice.domain.user.UserRepository;
import com.blog.blogrestpractice.dto.user.UserSaveRequestDto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserApiControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @AfterEach
    public void cleanup() throws Exception {
        userRepository.deleteAll();
    }

    @Transactional
    @Test
    public void user_save_test() throws Exception {
        //given
        String username = "test";
        String nickname = "testNick";

        UserSaveRequestDto userSaveRequestDto = UserSaveRequestDto.builder()
            .username(username)
            .password(bCryptPasswordEncoder.encode("1234"))
            .email("test@naver.com")
            .nickname(nickname)
            .role(Role.USER)
            .build();

        String url = "http://localhost:" + port + "/api/v1/user";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, userSaveRequestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<User> users = userRepository.findAll();
        assertThat(users.get(0).getUsername()).isEqualTo(username);
        assertThat(users.get(0).getNickname()).isEqualTo(nickname);
    }

}