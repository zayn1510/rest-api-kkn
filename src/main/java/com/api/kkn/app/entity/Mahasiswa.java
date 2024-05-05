package com.api.kkn.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "tbl_mahasiswa")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Mahasiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mhs")
    private Integer idMhs;

    @Column(name = "nim_mhs", nullable = false, length = 12)
    private String nimMhs;

    @Column(name = "nama_mhs", nullable = false, length = 40)
    private String namaMhs;

    @Column(name = "tempat_lahir_mhs", length = 30)
    private String tempatLahirMhs;

    @Temporal(TemporalType.DATE)
    @Column(name = "tgl_lahir_mhs")
    private Date tglLahirMhs;

    @Column(name = "nomor_hp_mhs", length = 12)
    private String nomorHpMhs;

    @Column(name = "email_mhs", length = 50)
    private String emailMhs;

    @Column(name = "angkatan_mhs", length = 6)
    private String angkatanMhs;

    @Column(name = "id_fakultas", nullable = false)
    private Integer idFakultas;

    @Column(name = "foto_mhs", length = 255)
    private String fotoMhs;

    @OneToOne
    @JoinColumn(name = "id_jurusan")
    private Jurusan jurusan;

}