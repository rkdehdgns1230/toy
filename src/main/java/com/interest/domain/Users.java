package com.interest.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Users extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "user_name")
    private String userName;

    @OneToMany(mappedBy = "users", fetch = FetchType.LAZY)
    private List<Post> postList = new ArrayList<>();

    @Builder
    public Users(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }
}
