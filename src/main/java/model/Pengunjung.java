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

public class Pengunjung {

    private int idPengunjung;
    private String nama;
    private int umur;
    private String jenisKelamin;
    private LocalDate tanggalKunjungan;

    public Pengunjung(
            int idPengunjung,
            String nama,
            int umur,
            String jenisKelamin,
            LocalDate tanggalKunjungan) {

        this.idPengunjung = idPengunjung;
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.tanggalKunjungan = tanggalKunjungan;
    }

    // Getter
    public int getIdPengunjung() {
        return idPengunjung;
    }

    public String getNama() {
        return nama;
    }

    public int getUmur() {
        return umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public LocalDate getTanggalKunjungan() {
        return tanggalKunjungan;
    }

    // Setter
    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public void setJenisKelamin(String jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setTanggalKunjungan(
            LocalDate tanggalKunjungan) {

        this.tanggalKunjungan = tanggalKunjungan;
    }

    // Method yang akan dioverride
    public void tampilkanData() {

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy");

        System.out.println("------------------------------------------");
        System.out.println("ID Pengunjung     : " + idPengunjung);
        System.out.println("Nama              : " + nama);
        System.out.println("Umur              : " + umur + " tahun");
        System.out.println("Jenis Kelamin     : " + jenisKelamin);
        System.out.println("Tanggal Kunjungan : "
                + tanggalKunjungan.format(formatter));
    }
}
