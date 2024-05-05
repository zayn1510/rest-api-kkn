package com.api.kkn.app.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.validator.constraints.Length;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@Table(name = "tbl_kkn")
@Entity(name = "tbl_kkn")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CalonKkn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id_mhs")
    private Mahasiswa idMhs;

    @OneToOne()
    @JoinColumn(name = "id_period_kkn")
    private PeriodeKkn idPeriodKkn;

    @Column(name = "kode_calon_kkn",length = 30)
    private String kodeCalonKkn;

    @Column(name = "desa",length = 50)
    private String namaDesa;

    @Column(name = "kecamatan",length = 50)
    private String namaKecamatan;

    @Column(name = "kabupaten",length = 50)
    private String namaKabupaten;

    @Column(name = "is_status")
    private Boolean status;

    @Column(name = "status_group")
    private Boolean statusGroup;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Timestamp updatedAt;

}
