package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.PeriodeKknDto;
import com.api.kkn.app.entity.PeriodeKkn;

public class PeriodeKknMapper {
    public static PeriodeKknDto mapDtoToEntity(PeriodeKkn periodeKkn) {
        return new PeriodeKknDto(
                periodeKkn.getIdPeriodeKkn(),
                periodeKkn.getTahunAkademik(),
                periodeKkn.getAngkatan(),
                periodeKkn.getStatus(),
                periodeKkn.getStatusPendaftaran(),
                periodeKkn.getTglAkademik(),
                periodeKkn.getTglMulai(),
                periodeKkn.getTglSelesai()
        );
    }
    public static PeriodeKkn mapEntityToDto(PeriodeKknDto periodeKknDto) {
        PeriodeKkn periodeKkn=new PeriodeKkn();
        periodeKkn.setTahunAkademik(periodeKknDto.getTahun_akademik());
        periodeKkn.setAngkatan(periodeKknDto.getAngkatan());
        periodeKkn.setStatus(periodeKknDto.getStatus());
        periodeKkn.setStatusPendaftaran(periodeKknDto.getStatus_pendaftaran());
        periodeKkn.setTglAkademik(periodeKknDto.getTgl_akademik());
        periodeKkn.setTglMulai(periodeKknDto.getTgl_mulai());
        periodeKkn.setTglSelesai(periodeKknDto.getTgl_selesai());
        return periodeKkn;
    }

    public static void updateDtoToEntity(PeriodeKknDto periodeKknDto, PeriodeKkn periodeKkn) {
        periodeKkn.setTahunAkademik(periodeKknDto.getTahun_akademik());
        periodeKkn.setAngkatan(periodeKknDto.getAngkatan());
        periodeKkn.setStatus(periodeKknDto.getStatus());
        periodeKkn.setStatusPendaftaran(periodeKknDto.getStatus_pendaftaran());
        periodeKkn.setTglAkademik(periodeKknDto.getTgl_akademik());
        periodeKkn.setTglMulai(periodeKknDto.getTgl_mulai());
        periodeKkn.setTglSelesai(periodeKknDto.getTgl_selesai());
    }
}
