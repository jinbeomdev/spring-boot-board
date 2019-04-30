package com.fasoo.boardtutorial.user;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(unique = true)
    @Embedded
    private Role role;

    @Embeddable
    public class Role {
        @Column
        @JoinColumn(name = "user_id")
        private String userId;

        @Column
        private String role;
    }
}
