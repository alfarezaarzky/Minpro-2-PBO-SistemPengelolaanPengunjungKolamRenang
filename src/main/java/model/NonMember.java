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

public class NonMember extends Pengunjung {

    private String jenisTiket;

    public NonMember(
            int idPengunjung,
            String nama,
            int umur,
            String jenisKelamin,
            LocalDate tanggalKunjungan,
            String jenisTiket) {

        super(
                idPengunjung,
                nama,
                umur,
                jenisKelamin,
                tanggalKunjungan
        );

        this.jenisTiket = jenisTiket;
    }

    public String getJenisTiket() {
        return jenisTiket;
    }

    public void setJenisTiket(String jenisTiket) {
        this.jenisTiket = jenisTiket;
    }

    @Override
    public void tampilkanData() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("------------------------------------------");
        System.out.println("Tipe              : NON-MEMBER");
        System.out.println("ID Pengunjung     : " + getIdPengunjung());
        System.out.println("Nama              : " + getNama());
        System.out.println("Umur              : " + getUmur() + " tahun");
        System.out.println("Jenis Kelamin     : " + getJenisKelamin());
        System.out.println("Tanggal Kunjungan : "
                + getTanggalKunjungan().format(formatter));
        System.out.println("Jenis Tiket       : " + jenisTiket);
    }
}
