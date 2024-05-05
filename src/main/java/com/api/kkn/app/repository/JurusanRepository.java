package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Jurusan;
import com.api.kkn.app.response.JurusanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JurusanRepository extends JpaRepository<Jurusan,Integer> {
    Page<Jurusan> findAll(Pageable pageable);
    // Menambahkan metode khusus untuk mencari Fakultas berdasarkan id Jurusan


}
