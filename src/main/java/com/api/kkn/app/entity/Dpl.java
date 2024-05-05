package com.api.kkn.app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name = "tbl_dpl")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dpl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dpl")
    private Integer idDpl;
    @OneToOne
    @JoinColumn(name = "id_periode_kkn")
    private PeriodeKkn periodeKkn;

    @Column(name = "nidn",length = 20)

    private String nidn;

    @Column(name = "nama_dosen",length = 50)
    private String namaDosen;

    @Column(name = "gelar_depan",length = 50)
    private String gelarDepan;

    @Column(name = "gelar_belakang",length = 50)
    private String gelarBelakang;

    @Column(name = "nomor_hp",length = 12)
    private String nomorHp;

    @Column(name = "email",unique = true)
    private String email;

    @CreationTimestamp
    @Column(name = "created_at",updatable = false)
    private Timestamp createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at",updatable = true)
    private Timestamp updatedAt;

}
