package com.blog.blogrestpractice.domain.user;

import com.blog.blogrestpractice.domain.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class User extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String email;

    @NotNull
    private String nickname;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    public void setPassword(String password) {
        this.password = password;
    }

    public void encodePassword(String password) {
        this.password = password;
    }

    public void update(String encodePassword, String nickname) {
        this.password = encodePassword;
        this.nickname = nickname;
    }
}
