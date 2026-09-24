/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utills;

/**
 *
 * @author Alfareza
 */

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class ValidasiInput {

    private Scanner scanner;

    public ValidasiInput(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputInteger(String pesan) {

        while (true) {

            System.out.print(pesan);

            String input =
                    scanner.nextLine().trim();

            if (input.isEmpty()) {
                System.out.println(
                        "Input tidak boleh kosong."
                );
                continue;
            }

            try {

                return Integer.parseInt(input);

            } catch (NumberFormatException e) {

                System.out.println(
                        "Input harus berupa angka."
                );
            }
        }
    }

    public int inputUmur(String pesan) {

        while (true) {

            int umur =
                    inputInteger(pesan);

            if (umur >= 1 && umur <= 100) {
                return umur;
            }

            System.out.println(
                    "Umur harus berada antara "
                    + "1 sampai 100 tahun."
            );
        }
    }

    public String inputNama(String pesan) {

        while (true) {

            System.out.print(pesan);

            String nama =
                    scanner.nextLine().trim();

            if (nama.isEmpty()) {

                System.out.println(
                        "Nama tidak boleh kosong."
                );

                continue;
            }

            if (!nama.matches("[a-zA-Z ]+")) {

                System.out.println(
                        "Nama hanya boleh mengandung "
                        + "huruf dan spasi."
                );

                continue;
            }

            if (nama.length() < 2) {

                System.out.println(
                        "Nama minimal 2 karakter."
                );

                continue;
            }

            if (nama.length() > 50) {

                System.out.println(
                        "Nama maksimal 50 karakter."
                );

                continue;
            }

            return nama;
        }
    }

    public String inputJenisKelamin() {

        while (true) {

            System.out.print(
                    "Jenis Kelamin (L/P): "
            );

            String pilihan =
                    scanner.nextLine()
                            .trim()
                            .toUpperCase();

            if (pilihan.equals("L")) {
                return "Laki-laki";
            }

            if (pilihan.equals("P")) {
                return "Perempuan";
            }

            System.out.println(
                    "Pilihan tidak valid. "
                    + "Masukkan L atau P."
            );
        }
    }

public LocalDate inputTanggal(String pesan) {

    DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd-MM-yyyy");

    while (true) {

        System.out.print(pesan);

        String input = scanner.nextLine().trim();

        if (input.isEmpty()) {
            System.out.println("Tanggal tidak boleh kosong.");
            continue;
        }

        if (!input.matches("\\d{2}-\\d{2}-\\d{4}")) {
            System.out.println(
                    "Format harus DD-MM-YYYY."
            );
            System.out.println(
                    "Contoh: 24-09-2026"
            );
            continue;
        }

        try {

            String[] bagian = input.split("-");

            int hari = Integer.parseInt(bagian[0]);
            int bulan = Integer.parseInt(bagian[1]);
            int tahun = Integer.parseInt(bagian[2]);

            if (bulan < 1 || bulan > 12) {
                System.out.println(
                        "Bulan harus antara 01 sampai 12."
                );
                continue;
            }

            if (hari < 1 || hari > 31) {
                System.out.println(
                        "Hari harus antara 01 sampai 31."
                );
                continue;
            }

            LocalDate tanggal =
                    LocalDate.of(tahun, bulan, hari);

            return tanggal;

        } catch (DateTimeException e) {

            System.out.println(
                    "Tanggal tidak valid."
            );
        }
    }
}

    public int inputMenu(
            int minimum,
            int maksimum) {

        while (true) {

            int pilihan =
                    inputInteger("Pilih menu: ");

            if (pilihan >= minimum
                    && pilihan <= maksimum) {

                return pilihan;
            }

            System.out.println(
                    "Pilihan harus antara "
                    + minimum
                    + " sampai "
                    + maksimum
                    + "."
            );
        }
    }

    public int inputTipePengunjung() {

        while (true) {

            System.out.println();
            System.out.println(
                    "Tipe Pengunjung:"
            );
            System.out.println(
                    "1. Member"
            );
            System.out.println(
                    "2. Non-Member"
            );

            int pilihan =
                    inputInteger(
                            "Pilih tipe: "
                    );

            if (pilihan == 1
                    || pilihan == 2) {

                return pilihan;
            }

            System.out.println(
                    "Pilihan hanya 1 atau 2."
            );
        }
    }

    public String inputNomorMember() {

        while (true) {

            System.out.print(
                    "Nomor Member: "
            );

            String nomor =
                    scanner.nextLine().trim();

            if (nomor.isEmpty()) {

                System.out.println(
                        "Nomor member tidak boleh kosong."
                );

                continue;
            }

            if (!nomor.matches(
                    "[A-Za-z0-9]+")) {

                System.out.println(
                        "Nomor member hanya boleh "
                        + "berupa huruf dan angka."
                );

                continue;
            }

            return nomor;
        }
    }

    public String inputJenisTiket() {

        while (true) {

            System.out.println();
            System.out.println(
                    "Jenis Tiket:"
            );
            System.out.println(
                    "1. Biasa"
            );
            System.out.println(
                    "2. VIP"
            );

            int pilihan =
                    inputInteger(
                            "Pilih jenis tiket: "
                    );

            if (pilihan == 1) {
                return "Biasa";
            }

            if (pilihan == 2) {
                return "VIP";
            }

            System.out.println(
                    "Pilihan tiket tidak tersedia."
            );
        }
    }
}
