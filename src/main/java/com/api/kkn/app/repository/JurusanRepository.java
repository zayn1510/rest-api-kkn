package com.api.kkn.app.repository;

import com.api.kkn.app.entity.Jurusan;
import com.api.kkn.app.response.JurusanResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


public interface JurusanRepository extends JpaRepository<Jurusan,Integer> {

    @Query(value = "SELECT j FROM Jurusan j JOIN FETCH j.fakultas")
    Page<Jurusan> findAllWithFakultas(Pageable pageable);


}
