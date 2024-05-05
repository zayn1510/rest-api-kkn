package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Fakultas;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FakultasRepository extends JpaRepository<Fakultas,Integer> {
    List<Fakultas> findByKodeFakultas(String kode_fakultas);
    Page<Fakultas> findAll(Pageable pageable);
}
