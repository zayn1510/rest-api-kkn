package com.api.kkn.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_desa")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Desa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_desa")
    private Integer idDesa;

    @OneToOne
    @JoinColumn(name = "id_periode_kkn")
    private PeriodeKkn idPeriode;

    @Column(name = "desa")
    private String desa;

    @Column(name = "kecamatan")
    private String kecamatan;

    @Column(name = "kabupaten")
    private String kabupaten;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private LocalDateTime updatedAt;
}
