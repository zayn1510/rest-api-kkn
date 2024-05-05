package com.api.kkn.app.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "tbl_jurusan")
@Entity(name = "tbl_jurusan")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Jurusan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_jurusan")
    private Integer idJurusan;
    @OneToOne
    @JoinColumn(name = "id_fakultas")
    private Fakultas fakultas;

    @Column(name = "kode_jurusan")
    private String kodeJurusan;

    @Column(name = "nama_jurusan")
    private String namaJurusan;


}
