package com.api.kkn.app.repository;
import com.api.kkn.app.entity.Mahasiswa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MahasiswaRepository extends JpaRepository<Mahasiswa,Integer> {
    Mahasiswa findByNimMhs(String nim);
    Mahasiswa findByIdMhs(Integer id);
    Page<Mahasiswa> findAll(Pageable pageable);

}
