package com.api.kkn.app.repository;
import com.api.kkn.app.entity.Mahasiswa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
    Mahasiswa findByNimMhs(String nim);
    Mahasiswa findByIdMhs(Integer id);

    @Query(value = "SELECT m from Mahasiswa m JOIN  FETCH m.jurusan")
    Page<Mahasiswa> findAllWithJurusan(Pageable pageable);

}
