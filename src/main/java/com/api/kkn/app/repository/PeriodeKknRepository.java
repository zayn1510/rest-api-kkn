package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Fakultas;
import com.api.kkn.app.entity.PeriodeKkn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeriodeKknRepository extends JpaRepository<PeriodeKkn,Integer> {
    Page<PeriodeKkn> findAll(Pageable pageable);
}
