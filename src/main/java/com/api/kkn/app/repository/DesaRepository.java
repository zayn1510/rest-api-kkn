package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Desa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DesaRepository extends JpaRepository<Desa,Integer> {
    Page<Desa> findAll(Pageable pageable);
}
