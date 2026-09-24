/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author Alfareza
 */
import model.Member;
import model.NonMember;
import model.Pengunjung;
import utills.IdGenerator;

import java.time.LocalDate;
import java.util.ArrayList;

public class ManajemenPengunjung {

    private ArrayList<Pengunjung> daftarPengunjung;

    public ManajemenPengunjung() {

        daftarPengunjung =
                new ArrayList<>();

        tambahDummyData();
    }

    private void tambahDummyData() {

        daftarPengunjung.add(
                new Member(
                        IdGenerator.generateId(),
                        "Andi",
                        20,
                        "Laki-laki",
                        LocalDate.of(
                                2026, 9, 24
                        ),
                        "MB001"
                )
        );

        daftarPengunjung.add(
                new NonMember(
                        IdGenerator.generateId(),
                        "Siti",
                        19,
                        "Perempuan",
                        LocalDate.of(
                                2026, 9, 24
                        ),
                        "Biasa"
                )
        );
    }

    public void tambahPengunjung(
            Pengunjung pengunjung) {

        daftarPengunjung.add(
                pengunjung
        );
    }

    public ArrayList<Pengunjung>
            getDaftarPengunjung() {

        return daftarPengunjung;
    }

    public Pengunjung cariPengunjungById(
            int idPengunjung) {

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung.getIdPengunjung()
                    == idPengunjung) {

                return pengunjung;
            }
        }

        return null;
    }

    public ArrayList<Pengunjung>
            cariPengunjungByNama(
                    String nama) {

        ArrayList<Pengunjung> hasil =
                new ArrayList<>();

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung.getNama()
                    .toLowerCase()
                    .contains(
                            nama.toLowerCase()
                    )) {

                hasil.add(pengunjung);
            }
        }

        return hasil;
    }

    public boolean ubahPengunjung(
            int idPengunjung,
            String nama,
            int umur,
            String jenisKelamin,
            LocalDate tanggalKunjungan) {

        Pengunjung pengunjung =
                cariPengunjungById(
                        idPengunjung
                );

        if (pengunjung != null) {

            pengunjung.setNama(nama);
            pengunjung.setUmur(umur);
            pengunjung.setJenisKelamin(
                    jenisKelamin
            );
            pengunjung.setTanggalKunjungan(
                    tanggalKunjungan
            );

            return true;
        }

        return false;
    }

    public boolean ubahNomorMember(
            int idPengunjung,
            String nomorMember) {

        Pengunjung pengunjung =
                cariPengunjungById(
                        idPengunjung
                );

        if (pengunjung instanceof Member) {

            Member member =
                    (Member) pengunjung;

            member.setNomorMember(
                    nomorMember
            );

            return true;
        }

        return false;
    }

    public boolean ubahJenisTiket(
            int idPengunjung,
            String jenisTiket) {

        Pengunjung pengunjung =
                cariPengunjungById(
                        idPengunjung
                );

        if (pengunjung instanceof NonMember) {

            NonMember nonMember =
                    (NonMember) pengunjung;

            nonMember.setJenisTiket(
                    jenisTiket
            );

            return true;
        }

        return false;
    }

    public boolean hapusPengunjung(
            int idPengunjung) {

        Pengunjung pengunjung =
                cariPengunjungById(
                        idPengunjung
                );

        if (pengunjung != null) {

            daftarPengunjung.remove(
                    pengunjung
            );

            return true;
        }

        return false;
    }

    public int hitungTotalPengunjung() {

        return daftarPengunjung.size();
    }

    public int hitungMember() {

        int jumlah = 0;

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung instanceof Member) {
                jumlah++;
            }
        }

        return jumlah;
    }

    public int hitungNonMember() {

        int jumlah = 0;

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung instanceof NonMember) {
                jumlah++;
            }
        }

        return jumlah;
    }

    public int hitungLakiLaki() {

        int jumlah = 0;

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung
                    .getJenisKelamin()
                    .equals("Laki-laki")) {

                jumlah++;
            }
        }

        return jumlah;
    }

    public int hitungPerempuan() {

        int jumlah = 0;

        for (Pengunjung pengunjung
                : daftarPengunjung) {

            if (pengunjung
                    .getJenisKelamin()
                    .equals("Perempuan")) {

                jumlah++;
            }
        }

        return jumlah;
    }

    public int generateIdBaru() {

        return IdGenerator.generateId();
    }
}