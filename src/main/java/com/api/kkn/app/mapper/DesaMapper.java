package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.DesaDto;
import com.api.kkn.app.entity.Desa;
import com.api.kkn.app.entity.PeriodeKkn;

public class DesaMapper {
    public static Desa toDesa(DesaDto desaDto){
        Desa desa = new Desa();
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setIdPeriodeKkn(desaDto.getId_periode_kkn());
        desa.setIdPeriode(periodeKkn);
        desa.setDesa(desaDto.getDesa());
        desa.setKecamatan(desaDto.getKecamatan());
        desa.setKabupaten(desaDto.getKabupaten());
        return desa;
    }

    public static void update(Desa desa, DesaDto desaDto) {
        desa.setDesa(desaDto.getDesa());
        desa.setKecamatan(desaDto.getKecamatan());
        desa.setKabupaten(desaDto.getKabupaten());
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setIdPeriodeKkn(desaDto.getId_periode_kkn());
        desa.setIdPeriode(periodeKkn);
    }
}
