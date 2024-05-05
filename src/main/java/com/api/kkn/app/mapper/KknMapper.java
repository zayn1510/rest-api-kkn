package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.KknDto;
import com.api.kkn.app.entity.CalonKkn;
import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.entity.PeriodeKkn;
import com.api.kkn.app.util.GenerateKode;

public class KknMapper {
    public static CalonKkn toCalonKkn(KknDto kknDto) {
        CalonKkn calonKkn=new CalonKkn();
        calonKkn.setKodeCalonKkn(GenerateKode.generateID());
        Mahasiswa mahasiswa=new Mahasiswa();
        mahasiswa.setIdMhs(kknDto.getMhs());
        calonKkn.setIdMhs(mahasiswa);
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setIdPeriodeKkn(kknDto.getPeriode_kkn());
        calonKkn.setIdPeriodKkn(periodeKkn);
        calonKkn.setStatus(kknDto.getStatus());
        calonKkn.setNamaDesa(kknDto.getDesa());
        calonKkn.setNamaKecamatan(kknDto.getKecamatan());
        calonKkn.setNamaKabupaten(kknDto.getKabupaten());
        calonKkn.setStatusGroup(kknDto.getGroup());
        return calonKkn;
    }
}
