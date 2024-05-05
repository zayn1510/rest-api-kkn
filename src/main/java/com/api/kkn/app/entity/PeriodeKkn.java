package com.api.kkn.app.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Table(name = "tbl_periode_kkn")
@Entity(name = "tbl_periode_kkn")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class PeriodeKkn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_periode_kkn")
    Integer idPeriodeKkn;
    @Column(name = "tahun_akademik")
    String tahunAkademik;
    @Column(name = "angkatan")
    String angkatan;
    @Column(name = "status")
    Integer status;
    @Column(name = "status_pendaftaran")
    Integer statusPendaftaran;
    @Column(name = "tgl_akademik")
    @Temporal(TemporalType.DATE)
    Date tglAkademik;
    @Column(name = "tgl_mulai")
    @Temporal(TemporalType.DATE)
    Date tglMulai;
    @Column(name = "tgl_selesai")
    @Temporal(TemporalType.DATE)
    Date tglSelesai;


}
