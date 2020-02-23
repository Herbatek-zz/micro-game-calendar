package com.piotrke.user.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.piotrke.user.dtos.UserProfile;
import com.piotrke.user.enums.AuthProvider;
import com.piotrke.user.util.DateAudit;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends DateAudit {

    @Id
    @GeneratedValue
    private String id;

    private String firstName;

    private String lastName;

    @Column(nullable = false, unique = true, updatable = false)
    private String username;

    @Lob
    private String password;

    @NaturalId
    @Column(nullable = false, unique = true)
    private String email;

    private String imageUrl;

    @Column(nullable = false)
    private Boolean emailVerified;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();


    @NotNull
    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    private String providerId;
}