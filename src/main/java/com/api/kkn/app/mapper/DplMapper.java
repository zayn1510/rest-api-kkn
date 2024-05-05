package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.DplDto;
import com.api.kkn.app.entity.Dpl;
import com.api.kkn.app.entity.PeriodeKkn;

public class DplMapper {

    public static Dpl toDpl(DplDto dplDto) {
        Dpl dpl = new Dpl();
        dpl.setNamaDosen(dplDto.getNama_dosen());
        dpl.setGelarDepan(dplDto.getGelar_depan());
        dpl.setGelarBelakang(dplDto.getGelar_belakang());
        dpl.setNidn(dplDto.getNidn());
        dpl.setEmail(dplDto.getEmail());
        dpl.setNomorHp(dplDto.getNomor_hp());
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setIdPeriodeKkn(dplDto.getId_periode_kkn());
        dpl.setPeriodeKkn(periodeKkn);
        return dpl;
    }

    public static void updateDto(Dpl dpl, DplDto dplDto) {
        dpl.setNamaDosen(dplDto.getNama_dosen());
        dpl.setGelarDepan(dplDto.getGelar_depan());
        dpl.setNidn(dplDto.getNidn());
        dpl.setEmail(dplDto.getEmail());
        dpl.setNomorHp(dplDto.getNomor_hp());
        dpl.setGelarBelakang(dplDto.getGelar_belakang());
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setIdPeriodeKkn(dplDto.getId_periode_kkn());
        dpl.setPeriodeKkn(periodeKkn);
    }
}
