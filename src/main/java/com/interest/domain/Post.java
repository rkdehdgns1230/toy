package com.interest.domain;

import com.interest.dto.PostUpdateRequestDto;
import com.interest.exception.CustomException;
import com.interest.exception.ExceptionMessage;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "view_count")
    private Long viewCount;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Users users;

    @Builder
    public Post(Long id, String title, String content, String password, Users users) {
        validateTitleAndContent(title, content);
        this.id = id;
        this.title = title;
        this.content = content;
        this.password = password;
        this.users = users;
        this.viewCount = 0L;
    }

    public void update(PostUpdateRequestDto requestDto){
        validatePassword(requestDto.getPassword());
        validateTitleAndContent(requestDto.getTitle(), requestDto.getContent());
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.lastModifiedAt = LocalDateTime.now();
    }

    private void validateTitleAndContent(String title, String content){
        if(title.length() >= 20){
            throw new CustomException(ExceptionMessage.POST_TITLE_LENGTH_TOO_LONG);
        }
        if(content.length() >= 50){
            throw new CustomException(ExceptionMessage.POST_CONTENT_LENGTH_TOO_LONG);
        }
    }

    private void validatePassword(String password){
        if(!this.password.equals(password)){
            throw new CustomException(ExceptionMessage.POST_PASSWORD_INVALID);
        }
    }
}
