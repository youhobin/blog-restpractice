package com.blog.blogrestpractice.domain.board;

import com.blog.blogrestpractice.domain.BaseTimeEntity;
import com.blog.blogrestpractice.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue
    @Column(name = "board_id")
    private Long id;

    private String title;

    private String content;

    private int count; //์กฐํ์

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    public void update(String updateTitle, String updateContent) {
        this.title = updateTitle;
        this.content = updateContent;
    }

    public void updateCount(int count) {
        this.count = count + 1;
    }
}
