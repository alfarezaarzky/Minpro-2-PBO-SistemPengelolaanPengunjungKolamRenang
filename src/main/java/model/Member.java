/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Alfareza
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Member extends Pengunjung {

    private String nomorMember;

    public Member(
            int idPengunjung,
            String nama,
            int umur,
            String jenisKelamin,
            LocalDate tanggalKunjungan,
            String nomorMember) {

        super(
                idPengunjung,
                nama,
                umur,
                jenisKelamin,
                tanggalKunjungan
        );

        this.nomorMember = nomorMember;
    }

    public String getNomorMember() {
        return nomorMember;
    }

    public void setNomorMember(String nomorMember) {
        this.nomorMember = nomorMember;
    }

    @Override
    public void tampilkanData() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("------------------------------------------");
        System.out.println("Tipe              : MEMBER");
        System.out.println("ID Pengunjung     : " + getIdPengunjung());
        System.out.println("Nama              : " + getNama());
        System.out.println("Umur              : " + getUmur() + " tahun");
        System.out.println("Jenis Kelamin     : " + getJenisKelamin());
        System.out.println("Tanggal Kunjungan : "
                + getTanggalKunjungan().format(formatter));
        System.out.println("Nomor Member      : " + nomorMember);
    }
}