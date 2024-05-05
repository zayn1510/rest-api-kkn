package com.api.kkn.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Table(name = "users")
@Entity(name = "users")
@Data
public class Users implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(nullable = true,name = "id_pengguna")
    private Integer idPengguna;
    @Column(nullable = false,name = "username")
    private String username;

    @Column(unique = true, length = 100, nullable = false,name = "email")
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(name = "token",nullable = true)
    private String token;

    @CreationTimestamp
    @Column(updatable = false, name = "email_verified_at")
    private Date emailVerified_at;

    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Date createdAt;

    @Column(name = "remember_token")
    String rememberToken;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    private Role role;
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
