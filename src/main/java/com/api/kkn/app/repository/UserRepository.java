package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Role;
import com.api.kkn.app.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {

    Optional<Users> findByEmail(String email);
    Users findByRole(Role role);
    Optional<Users> findByUsername(String username);
    Users findByIdPengguna(Integer idPengguna);
}

