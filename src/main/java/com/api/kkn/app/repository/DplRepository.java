package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Dpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DplRepository extends JpaRepository<Dpl, Integer> {
    Page<Dpl> findAll(Pageable pageable);
}
