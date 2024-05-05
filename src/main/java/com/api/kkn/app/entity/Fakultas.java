package com.api.kkn.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "tbl_fakultas")
@Entity(name = "tbl_fakutlas")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Fakultas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_fakultas")
    private Integer idFakultas;

    @Column(name = "kode_fakultas", nullable = true, length = 12)
    private String kodeFakultas;

    @Column(name = "nama_fakultas", nullable = true, length = 100)
    private String namaFakultas;
}
