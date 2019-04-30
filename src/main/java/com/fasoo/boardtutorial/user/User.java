package com.fasoo.boardtutorial.user;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String userId;

    @Column
    private String userPw;

    @Column
    private Boolean enabled = Boolean.TRUE;
}
