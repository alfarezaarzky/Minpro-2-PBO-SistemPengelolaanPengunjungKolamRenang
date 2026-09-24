/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author Alfareza
 */
import controller.ManajemenPengunjung;
import model.Member;
import model.NonMember;
import model.Pengunjung;
import utills.ValidasiInput;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PengunjungView {

    private Scanner scanner;
    private ValidasiInput validasi;

    public PengunjungView() {

        scanner = new Scanner(System.in);

        validasi =
                new ValidasiInput(scanner);
    }

    public void jalankanProgram(
            ManajemenPengunjung manajemen) {

        int pilihan;

        do {

            tampilkanMenu();

            pilihan =
                    validasi.inputMenu(0, 6);

            switch (pilihan) {

                case 1:
                    tambahData(manajemen);
                    break;

                case 2:
                    tampilkanData(manajemen);
                    break;

                case 3:
                    ubahData(manajemen);
                    break;

                case 4:
                    hapusData(manajemen);
                    break;

                case 5:
                    cariData(manajemen);
                    break;

                case 6:
                    tampilkanStatistik(manajemen);
                    break;

                case 0:
                    keluar();
                    break;
            }

        } while (pilihan != 0);

        scanner.close();
    }

    private void tampilkanMenu() {

        System.out.println();

        System.out.println(
                "============================================="
        );

        System.out.println(
                "==       SISTEM MANAJEMEN PENGUNJUNG       =="
        );

        System.out.println(
                "==              KOLAM RENANG               =="
        );

        System.out.println(
                "============================================="
        );

        System.out.println(
                "== 1. Registrasi Pengunjung                 =="
        );

        System.out.println(
                "== 2. Tampilkan Semua Pengunjung            =="
        );

        System.out.println(
                "== 3. Ubah Data Pengunjung                  =="
        );

        System.out.println(
                "== 4. Hapus Data Pengunjung                 =="
        );

        System.out.println(
                "== 5. Cari Pengunjung Berdasarkan Nama      =="
        );

        System.out.println(
                "== 6. Statistik Pengunjung                  =="
        );

        System.out.println(
                "== 0. Keluar                                =="
        );

        System.out.println(
                "=========================================="
        );
    }

    private void tambahData(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n===== REGISTRASI PENGUNJUNG ====="
        );

        int id =
                manajemen.generateIdBaru();

        System.out.println(
                "ID Pengunjung : "
                + id
        );

        String nama =
                validasi.inputNama(
                        "Nama Pengunjung: "
                );

        int umur =
                validasi.inputUmur(
                        "Umur: "
                );

        String jenisKelamin =
                validasi.inputJenisKelamin();

        LocalDate tanggal =
                validasi.inputTanggal(
                        "Tanggal Kunjungan "
                        + "(DD-MM-YYYY): "
                );

        int tipe =
                validasi.inputTipePengunjung();

        if (tipe == 1) {

            String nomorMember =
                    validasi.inputNomorMember();

            Member member =
                    new Member(
                            id,
                            nama,
                            umur,
                            jenisKelamin,
                            tanggal,
                            nomorMember
                    );

            manajemen.tambahPengunjung(
                    member
            );

        } else {

            String jenisTiket =
                    validasi.inputJenisTiket();

            NonMember nonMember =
                    new NonMember(
                            id,
                            nama,
                            umur,
                            jenisKelamin,
                            tanggal,
                            jenisTiket
                    );

            manajemen.tambahPengunjung(
                    nonMember
            );
        }

        System.out.println(
                "\n✓ Data pengunjung berhasil ditambahkan."
        );
    }

    private void tampilkanData(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n===== DAFTAR PENGUNJUNG ====="
        );

        ArrayList<Pengunjung> daftar =
                manajemen.getDaftarPengunjung();

        if (daftar.isEmpty()) {

            System.out.println(
                    "Belum ada data pengunjung."
            );

            return;
        }

        for (Pengunjung pengunjung
                : daftar) {

            pengunjung.tampilkanData();

            System.out.println(
                    "------------------------------------------"
            );
        }
    }

    private void ubahData(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n===== UBAH DATA PENGUNJUNG ====="
        );

        tampilkanData(manajemen);

        int id =
                validasi.inputInteger(
                        "\nMasukkan ID data "
                        + "yang ingin diubah: "
                );

        Pengunjung pengunjung =
                manajemen.cariPengunjungById(
                        id
                );

        if (pengunjung == null) {

            System.out.println(
                    "Data pengunjung tidak ditemukan."
            );

            return;
        }

        System.out.println(
                "\nMasukkan data baru:"
        );

        String nama =
                validasi.inputNama(
                        "Nama baru: "
                );

        int umur =
                validasi.inputUmur(
                        "Umur baru: "
                );

        String jenisKelamin =
                validasi.inputJenisKelamin();

        LocalDate tanggal =
                validasi.inputTanggal(
                        "Tanggal Kunjungan baru "
                        + "(DD-MM-YYYY): "
                );

        manajemen.ubahPengunjung(
                id,
                nama,
                umur,
                jenisKelamin,
                tanggal
        );

        if (pengunjung instanceof Member) {

            String nomorMember =
                    validasi.inputNomorMember();

            manajemen.ubahNomorMember(
                    id,
                    nomorMember
            );

        } else if (
                pengunjung instanceof NonMember) {

            String jenisTiket =
                    validasi.inputJenisTiket();

            manajemen.ubahJenisTiket(
                    id,
                    jenisTiket
            );
        }

        System.out.println(
                "\n✓ Data berhasil diubah."
        );
    }

    private void hapusData(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n===== HAPUS DATA PENGUNJUNG ====="
        );

        tampilkanData(manajemen);

        int id =
                validasi.inputInteger(
                        "\nMasukkan ID yang "
                        + "ingin dihapus: "
                );

        Pengunjung pengunjung =
                manajemen.cariPengunjungById(
                        id
                );

        if (pengunjung == null) {

            System.out.println(
                    "Data pengunjung tidak ditemukan."
            );

            return;
        }

        System.out.println(
                "\nData yang akan dihapus:"
        );

        pengunjung.tampilkanData();

        System.out.println(
                "\nApakah Anda yakin "
                + "ingin menghapus data ini?"
        );

        System.out.println(
                "1. Ya"
        );

        System.out.println(
                "2. Tidak"
        );

        int konfirmasi =
                validasi.inputMenu(1, 2);

        if (konfirmasi == 1) {

            manajemen.hapusPengunjung(id);

            System.out.println(
                    "✓ Data berhasil dihapus."
            );

        } else {

            System.out.println(
                    "Penghapusan dibatalkan."
            );
        }
    }

    private void cariData(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n===== CARI PENGUNJUNG ====="
        );

        String nama =
                validasi.inputNama(
                        "Masukkan nama: "
                );

        ArrayList<Pengunjung> hasil =
                manajemen.cariPengunjungByNama(
                        nama
                );

        if (hasil.isEmpty()) {

            System.out.println(
                    "\nData dengan nama \""
                    + nama
                    + "\" tidak ditemukan."
            );

            return;
        }

        System.out.println(
                "\nData pengunjung ditemukan:"
        );

        for (Pengunjung pengunjung
                : hasil) {

            pengunjung.tampilkanData();

            System.out.println(
                    "------------------------------------------"
            );
        }
    }

    private void tampilkanStatistik(
            ManajemenPengunjung manajemen) {

        System.out.println(
                "\n╔══════════════════════════════════════════╗"
        );

        System.out.println(
                "║          STATISTIK PENGUNJUNG           ║"
        );

        System.out.println(
                "╠══════════════════════════════════════════╣"
        );

        System.out.println(
                "║ Total Pengunjung : "
                + manajemen.hitungTotalPengunjung()
        );

        System.out.println(
                "║ Member           : "
                + manajemen.hitungMember()
        );

        System.out.println(
                "║ Non-Member       : "
                + manajemen.hitungNonMember()
        );

        System.out.println(
                "║ Laki-laki        : "
                + manajemen.hitungLakiLaki()
        );

        System.out.println(
                "║ Perempuan        : "
                + manajemen.hitungPerempuan()
        );

        System.out.println(
                "╚══════════════════════════════════════════╝"
        );
    }

    private void keluar() {

        System.out.println();

        System.out.println(
                "=========================================="
        );

        System.out.println(
                " Terima kasih telah menggunakan sistem."
        );

        System.out.println(
                " Sistem Manajemen Pengunjung Kolam Renang"
        );

        System.out.println(
                "=========================================="
        );
    }
}
