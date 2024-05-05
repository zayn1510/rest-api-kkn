package com.api.kkn.app.mapper;

import com.api.kkn.app.dto.MahasiswaDto;
import com.api.kkn.app.entity.Jurusan;
import com.api.kkn.app.entity.Mahasiswa;
import com.api.kkn.app.util.DateUtil;
import lombok.SneakyThrows;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MahasiswaMapper {
    @SneakyThrows
    public static Mahasiswa modelToDto(MahasiswaDto mahasiswaDto){
        Mahasiswa mahasiswa = new Mahasiswa();
        mahasiswa.setNimMhs(mahasiswaDto.getNimMhs());
        mahasiswa.setNamaMhs(mahasiswaDto.getNamaMhs());
        mahasiswa.setIdFakultas(mahasiswaDto.getIdFakultas());
        Jurusan jurusan=new Jurusan();
        jurusan.setIdJurusan(mahasiswaDto.getIdJurusan());
        mahasiswa.setJurusan(jurusan);
        mahasiswa.setAngkatanMhs(mahasiswaDto.getAngkatanMhs());
        mahasiswa.setNomorHpMhs(mahasiswaDto.getNomorHpMhs());
        mahasiswa.setEmailMhs(mahasiswaDto.getEmailMhs());
        Date date=DateUtil.convertStringToDate(mahasiswaDto.getTglLahirMhs());
        mahasiswa.setTglLahirMhs(date);
        mahasiswa.setTempatLahirMhs(mahasiswaDto.getTempatLahirMhs());
        return mahasiswa;
    }

    @SneakyThrows
    public static void updateModel(MahasiswaDto mahasiswaDto, Mahasiswa update) {
        update.setNimMhs(mahasiswaDto.getNimMhs());
        update.setNamaMhs(mahasiswaDto.getNamaMhs());
        update.setIdFakultas(mahasiswaDto.getIdFakultas());
        update.setAngkatanMhs(mahasiswaDto.getAngkatanMhs());
        update.setNomorHpMhs(mahasiswaDto.getNomorHpMhs());
        update.setEmailMhs(mahasiswaDto.getEmailMhs());
        update.setTempatLahirMhs(mahasiswaDto.getTempatLahirMhs());
        Date date= DateUtil.convertStringToDate(mahasiswaDto.getTglLahirMhs());
        update.setTglLahirMhs(date);
    }
}
