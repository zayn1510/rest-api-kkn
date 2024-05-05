package com.api.kkn.app.repository;

import com.api.kkn.app.entity.CalonKkn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KknRepository extends JpaRepository<CalonKkn,Integer> {
    Page<CalonKkn> findAll(Pageable pageable);
}
