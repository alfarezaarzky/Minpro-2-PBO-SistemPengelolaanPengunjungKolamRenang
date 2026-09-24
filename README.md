# Dokumentasi Program PBO

## Deskripsi Singkat Program

Program ini merupakan aplikasi berbasis Java yang dibuat untuk menerapkan konsep Pemrograman Berorientasi Objek (PBO). Program yang dibuat adalah **Sistem Manajemen Data Pengunjung Kolam Renang** yang digunakan untuk mengelola data pengunjung yang datang ke kolam renang.

Program ini berfokus pada pengelolaan data pengunjung, mulai dari proses registrasi, menampilkan data, mengubah data, menghapus data, hingga mencari pengunjung berdasarkan nama.

Program memiliki beberapa fitur utama, yaitu:

* Menambahkan data pengunjung.
* Menampilkan seluruh data pengunjung.
* Mengubah data pengunjung.
* Menghapus data pengunjung.
* Mencari data pengunjung berdasarkan nama.
* Menghasilkan ID pengunjung secara otomatis.
* Membedakan pengunjung menjadi Member dan Non-Member.
* Menampilkan statistik jumlah pengunjung.
* Melakukan validasi terhadap input pengguna.
* Menyediakan dummy data awal agar data langsung tersedia saat program dijalankan.

Program juga menerapkan beberapa konsep PBO, yaitu **class, object, attribute/property, constructor, method, ArrayList, access modifier, encapsulation, inheritance, polymorphism, percabangan, dan perulangan**.

---

## Penjelasan Alur Program

Alur kerja program secara umum adalah sebagai berikut:

1. Program dijalankan melalui class `Main` sebagai entry point.
2. Program membuat objek `ManajemenPengunjung` untuk mengelola data pengunjung.
3. Program membuat objek `PengunjungView` untuk menampilkan menu dan menerima interaksi dari pengguna.
4. Program secara otomatis memasukkan dummy data awal ke dalam `ArrayList`.
5. Program menampilkan menu utama kepada pengguna.
6. Pengguna memilih menu berdasarkan pilihan yang tersedia.
7. Program memproses pilihan pengguna menggunakan percabangan `switch`.
8. Jika pengguna memilih:

   * **Registrasi Pengunjung**, pengguna memasukkan nama, umur, jenis kelamin, tanggal kunjungan, serta memilih tipe Member atau Non-Member. ID pengunjung dibuat secara otomatis oleh sistem.
   * **Tampilkan Semua Pengunjung**, program menampilkan seluruh data yang tersimpan dalam `ArrayList` menggunakan perulangan.
   * **Ubah Data Pengunjung**, pengguna memilih ID pengunjung yang akan diubah, kemudian memasukkan data baru.
   * **Hapus Data Pengunjung**, pengguna memilih ID pengunjung yang akan dihapus dan melakukan konfirmasi sebelum data dihapus.
   * **Cari Pengunjung Berdasarkan Nama**, pengguna memasukkan nama atau sebagian nama, kemudian program menampilkan data yang sesuai.
   * **Statistik Pengunjung**, program menampilkan jumlah total pengunjung, jumlah Member, Non-Member, serta jumlah berdasarkan jenis kelamin.
   * **Keluar**, program dihentikan.
9. Setelah suatu proses selesai, program kembali menampilkan menu utama.
10. Perulangan terus berjalan sampai pengguna memilih menu **Keluar**.

### Gambaran Alur

```text
                 ┌─────────────┐
                 │    Main     │
                 └──────┬──────┘
                        │
                        ▼
              ┌──────────────────┐
              │ PengunjungView   │
              │      (View)      │
              └────────┬─────────┘
                       │
                       ▼
              ┌──────────────────────┐
              │ ManajemenPengunjung  │
              │    (Controller)      │
              └──────────┬───────────┘
                         │
                         ▼
                 ┌──────────────┐
                 │    Model     │
                 ├──────────────┤
                 │ Pengunjung   │
                 │ Member       │
                 │ NonMember    │
                 └──────────────┘
```

---

## Struktur Package

Program menggunakan struktur package agar kode lebih terorganisir dan menerapkan konsep **MVC (Model-View-Controller)**.

Struktur package program adalah:

```text
com.mycompany.sistempengelolaankolamrenang
│
├── Main.java
│
├── model
│   ├── Pengunjung.java
│   ├── Member.java
│   └── NonMember.java
│
├── controller
│   └── ManajemenPengunjung.java
│
├── view
│   └── PengunjungView.java
│
└── utils
    ├── ValidasiInput.java
    └── IdGenerator.java
```

### Penjelasan Package

**1. Package Model**

Package `model` berisi class yang merepresentasikan data dalam program.

* `Pengunjung.java` sebagai superclass.
* `Member.java` sebagai subclass dari `Pengunjung`.
* `NonMember.java` sebagai subclass dari `Pengunjung`.

**2. Package Controller**

Package `controller` berisi `ManajemenPengunjung.java` yang bertugas mengelola proses data pengunjung, seperti tambah, tampil, cari, ubah, dan hapus data.

**3. Package View**

Package `view` berisi `PengunjungView.java` yang bertugas menampilkan menu dan berinteraksi dengan pengguna.

**4. Package Utils**

Package `utils` berisi class pendukung program.

* `ValidasiInput.java` digunakan untuk melakukan validasi input.
* `IdGenerator.java` digunakan untuk menghasilkan ID pengunjung secara otomatis.

**5. Main.java**

`Main.java` digunakan sebagai entry point untuk menjalankan program.

---

## Penerapan Encapsulation

Program menerapkan **encapsulation** dengan membatasi akses langsung terhadap atribut menggunakan access modifier `private`.

Contohnya pada class `Pengunjung`:

<img width="413" height="131" alt="image" src="https://github.com/user-attachments/assets/2a04844c-c222-4be0-b82f-6b2c2c9295d2" />


Atribut tersebut tidak dapat diakses secara langsung dari class lain. Program menyediakan getter dan setter untuk mengakses atau mengubah data.

Contohnya:

```java
public String getNama() {
    return nama;
}

public void setNama(String nama) {
    this.nama = nama;
}
```

Dengan menerapkan encapsulation, data yang terdapat pada objek pengunjung menjadi lebih terkontrol karena class lain tidak dapat mengubah atribut secara langsung.

---

## Penerapan Inheritance

Program menerapkan **inheritance** dengan menggunakan class `Pengunjung` sebagai superclass dan class `Member` serta `NonMember` sebagai subclass.

Struktur inheritance:

```text
                 Pengunjung
                     │
            ┌────────┴────────┐
            │                 │
         Member           NonMember
```

Class `Pengunjung` memiliki atribut umum seperti:

* ID Pengunjung
* Nama
* Umur
* Jenis Kelamin
* Tanggal Kunjungan

Class `Member` mewarisi atribut dan method dari class `Pengunjung`, kemudian memiliki atribut tambahan berupa `nomorMember`.

Class `NonMember` juga mewarisi atribut dan method dari class `Pengunjung`, kemudian memiliki atribut tambahan berupa `jenisTiket`.

Contoh penerapan inheritance pada `Member`:

<img width="457" height="44" alt="image" src="https://github.com/user-attachments/assets/c970ec3a-979d-4d09-bd90-84368e34e445" />

Sedangkan pada `NonMember`:

<img width="451" height="44" alt="image" src="https://github.com/user-attachments/assets/6d750490-ae9a-4a64-a2c6-f22fd6de409b" />

Penggunaan inheritance membuat beberapa data dan method yang sama tidak perlu ditulis ulang pada setiap class.

---

## Penerapan Polymorphism

Program menerapkan **polymorphism** melalui method overriding pada method `tampilkanData()`.

Pada superclass `Pengunjung` terdapat method:

<img width="340" height="29" alt="image" src="https://github.com/user-attachments/assets/63d05856-787c-4e3a-a5ce-59be41818810" />

Method tersebut kemudian dioverride pada class `Member`:

<img width="374" height="72" alt="image" src="https://github.com/user-attachments/assets/e3899c86-57b4-40e4-b597-426a0a1ab6dc" />

dan pada class `NonMember`:

<img width="390" height="66" alt="image" src="https://github.com/user-attachments/assets/990b59f1-0f84-4753-928b-c0d74b1afc61" />

Dengan demikian, ketika program melakukan perulangan:

<img width="375" height="73" alt="image" src="https://github.com/user-attachments/assets/31a1ef69-39db-4c81-ad70-c22b471949d0" />

Java akan menjalankan `tampilkanData()` sesuai dengan objek sebenarnya. Jika objek merupakan `Member`, maka method pada `Member` dijalankan. Jika objek merupakan `NonMember`, maka method pada `NonMember` dijalankan.

Hal tersebut merupakan penerapan **polymorphism melalui method overriding**.

---

## Penerapan Access Modifier

Program menerapkan access modifier untuk mengatur tingkat akses terhadap atribut dan method.

Pada class `Pengunjung`, atribut menggunakan `private`:

<img width="413" height="119" alt="image" src="https://github.com/user-attachments/assets/3abcd550-da44-4c22-a7af-017c9bd07d5e" />

Sedangkan constructor, getter, setter, dan beberapa method menggunakan `public`.

Penggunaan `private` membantu membatasi akses langsung terhadap atribut sehingga data dapat dikelola melalui method yang telah disediakan.

---

## Penerapan Validasi Input

Program menerapkan validasi input untuk memastikan data yang dimasukkan pengguna sesuai dengan ketentuan.

Validasi dilakukan melalui class `ValidasiInput`.

Beberapa validasi yang diterapkan antara lain:

* Nama tidak boleh kosong.
* Nama hanya boleh mengandung huruf dan spasi.
* Nama memiliki batas minimal dan maksimal karakter.
* Umur harus berupa angka.
* Umur harus berada antara 1 sampai 100 tahun.
* Jenis kelamin hanya menerima pilihan L atau P.
* Tipe pengunjung hanya menerima Member atau Non-Member.
* Nomor Member tidak boleh kosong.
* Jenis tiket hanya menerima Biasa atau VIP.
* Tanggal kunjungan tidak boleh kosong.
* Tanggal harus menggunakan format `DD-MM-YYYY`.
* Tanggal yang tidak valid akan ditolak.
* Pilihan menu harus berada pada pilihan yang tersedia.

Contoh validasi nama:

<img width="454" height="207" alt="image" src="https://github.com/user-attachments/assets/ce64ac22-9b21-4e08-87c7-99e971047748" />

Validasi tanggal dilakukan agar input seperti:

```text
1111
99-99-2026
31-02-2026
```

tidak diterima oleh program.

Contoh tanggal yang benar:

```text
24-09-2026
```

Validasi tersebut digunakan untuk mengurangi kesalahan input dan menjaga data yang tersimpan agar sesuai dengan format yang telah ditentukan.

---

## Penerapan ID Otomatis

Program tidak meminta pengguna memasukkan ID secara manual. ID dibuat secara otomatis menggunakan class `IdGenerator`.

ID memiliki pola berdasarkan tahun dan nomor urut.

Contohnya:

```text
2026001
2026002
2026003
2026004
```

Bagian `2026` menunjukkan tahun, sedangkan tiga angka terakhir menunjukkan nomor urut pengunjung.

Contoh method:

<img width="484" height="145" alt="image" src="https://github.com/user-attachments/assets/a34410bf-9462-42a3-bd48-b9aadaa08046" />

Dengan sistem tersebut, pengguna tidak perlu menentukan ID sendiri sehingga kemungkinan terjadinya ID yang sama dapat dikurangi.

---

## Penerapan ArrayList dan Dummy Data

Program menggunakan `ArrayList` untuk menyimpan data pengunjung.

Contohnya:

<img width="547" height="50" alt="image" src="https://github.com/user-attachments/assets/c38a19ca-4448-44b9-a646-dcebb71d76ee" />

ArrayList dibuat pada constructor:

<img width="334" height="69" alt="image" src="https://github.com/user-attachments/assets/6b440e3b-d885-4ac3-a89b-3afa916e9708" />

Program juga menyediakan **dummy data awal** agar ketika program pertama kali dijalankan, menu tampilkan data sudah memiliki data yang dapat ditampilkan.

Contoh dummy data terdiri dari:

* 1 data Member.
* 1 data Non-Member.

Data tersebut dimasukkan ke dalam `ArrayList` melalui method:

<img width="401" height="57" alt="image" src="https://github.com/user-attachments/assets/589f415d-5c37-4c78-8540-3dc5c0fe192a" />

Dengan adanya dummy data, pengguna dapat langsung mencoba fitur **Read/Tampilkan Data** tanpa harus melakukan input data terlebih dahulu.

---

## Penerapan CRUD

Program menerapkan operasi CRUD dalam pengelolaan data pengunjung.

| CRUD   | Penerapan                  |
| ------ | -------------------------- |
| Create | Registrasi Pengunjung      |
| Read   | Tampilkan Semua Pengunjung |
| Update | Ubah Data Pengunjung       |
| Delete | Hapus Data Pengunjung      |

### Create

Pengguna dapat menambahkan data pengunjung baru melalui menu **Registrasi Pengunjung**.

<img width="337" height="889" alt="image" src="https://github.com/user-attachments/assets/de24f03b-f0bc-499a-974e-b160b7b766e2" />

### Read

Program menampilkan seluruh data pengunjung yang tersimpan di dalam `ArrayList`.

### Update

Pengguna dapat mengubah informasi pengunjung yang sudah tersimpan.

<img width="313" height="325" alt="image" src="https://github.com/user-attachments/assets/85af1f97-002e-4025-baa1-b0e6a720b30b" />

<img width="305" height="128" alt="image" src="https://github.com/user-attachments/assets/09aadbe5-5b4c-478b-a9f2-2a440ab4cfd0" />

### Delete

Pengguna dapat menghapus data pengunjung berdasarkan ID setelah melakukan konfirmasi.

<img width="280" height="702" alt="image" src="https://github.com/user-attachments/assets/83176f8c-1728-4488-b973-13ea3ce784ef" />

<img width="314" height="306" alt="image" src="https://github.com/user-attachments/assets/c6971f00-389c-47d8-916f-d0c39858b03d" />

---

## Penerapan Perulangan dan Percabangan

Program menggunakan perulangan agar menu utama tetap berjalan sampai pengguna memilih menu keluar.

Contohnya:

<img width="491" height="280" alt="image" src="https://github.com/user-attachments/assets/a8e604d0-4208-4524-a2a1-8a0a550ad9c6" />

Percabangan `switch` digunakan untuk menentukan proses berdasarkan menu yang dipilih pengguna.

Program juga menggunakan perulangan `for` untuk menampilkan data pengunjung yang tersimpan dalam `ArrayList`.

Contohnya:

<img width="367" height="55" alt="image" src="https://github.com/user-attachments/assets/0ca536ce-f8a8-4a02-95f1-5d684738f1ee" />

---

## Nilai Tambah yang Diterapkan

1. **Struktur MVC**

   * Model
   * View
   * Controller

2. **Polymorphism**

   * Method overriding pada `tampilkanData()`.

3. **ID Otomatis**

   * ID dibuat secara otomatis menggunakan pola tahun dan nomor urut.

4. **Validasi Input**

   * Validasi nama, umur, jenis kelamin, tanggal, tipe pengunjung, tiket, dan menu.

5. **Dummy Data**

   * Data awal Member dan Non-Member dimasukkan ke dalam `ArrayList`.

6. **Pencarian Berdasarkan Nama**

   * Fitur pencarian menggunakan nama pengunjung, bukan ID.

7. **Statistik Pengunjung**

   * Menampilkan jumlah total pengunjung, Member, Non-Member, serta jumlah berdasarkan jenis kelamin.

---

## Kesimpulan

Sistem Manajemen Data Pengunjung Kolam Renang merupakan program Java yang digunakan untuk mengelola data pengunjung secara terstruktur. Program telah menerapkan konsep dasar Pemrograman Berorientasi Objek seperti class, object, constructor, attribute, method, ArrayList, percabangan, dan perulangan.

Program juga dikembangkan dengan menerapkan **encapsulation, inheritance, polymorphism, access modifier, validasi input, struktur MVC, ID otomatis, dan dummy data**. Pengembangan tersebut membuat program lebih terstruktur serta memberikan validasi dan pembagian tugas antar-class yang lebih jelas.
