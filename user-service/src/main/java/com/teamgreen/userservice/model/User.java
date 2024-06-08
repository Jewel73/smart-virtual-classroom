package com.teamgreen.userservice.model;

import lombok.*;

import javax.persistence.*;

import com.teamgreen.userservice.enums.Active;
import com.teamgreen.userservice.enums.Role;
import com.teamgreen.userservice.request.UserDetailsRequest;

@Entity(name = "users")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User extends BaseEntity {
    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false, updatable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
//    private String role;

    @Enumerated(EnumType.STRING)
    private Active active;

    @Embedded
    private UserDetails userDetails;
}
