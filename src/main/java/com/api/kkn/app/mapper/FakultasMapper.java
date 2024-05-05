package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.FakultasDto;
import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.entity.Fakultas;
import com.api.kkn.app.entity.PeriodeKkn;

public class FakultasMapper {

    public static void updateDtoToEntity(FakultasDto fakultasDto, Fakultas fakultas) {
        fakultas.setKodeFakultas(fakultasDto.getKode_fakultas());
        fakultas.setNamaFakultas(fakultasDto.getNama_fakultas());
    }
}
