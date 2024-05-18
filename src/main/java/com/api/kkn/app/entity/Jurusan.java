package com.api.kkn.app.entity;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Table(name = "tbl_jurusan")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Jurusan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurusan")
    private Integer idJurusan;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_fakultas")
    private Fakultas fakultas;

    @Column(name = "kode_jurusan")
    private String kodeJurusan;

    @Column(name = "nama_jurusan")
    private String namaJurusan;


}
