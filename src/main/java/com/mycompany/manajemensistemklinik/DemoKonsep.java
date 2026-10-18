package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

public class DemoKonsep {

    private DemoKonsep() {
    }

    public static void classObject() {
        Tampilan.judul("Pert. 3 - Class, Object & Constructor");
        Tampilan.info("Class Pasien = cetak biru. Object = wujud nyatanya.");
        Tampilan.info("Dua objek dibuat dari class yang sama dengan 'new'.");
        Tampilan.info("(Objek contoh tidak disimpan ke daftar pasien.)\n");

        Pasien a = new Pasien("TMP1", "Contoh Satu", 20, "Laki-laki", "Pusing");
        Pasien b = new Pasien("TMP2", "Contoh Dua", 22, "Perempuan", "Flu");
        Tampilan.info("Constructor Pasien otomatis jalan saat 'new'.");

        a.tampilkanInfo();
        b.tampilkanInfo();

        Tampilan.subjudul("Ubah keluhan objek pertama saja");
        a.setKeluhan("Sakit perut");
        Tampilan.baris("Objek 1", a.getKeluhan());
        Tampilan.baris("Objek 2", b.getKeluhan());
        Tampilan.konsep("Field = data, method = perilaku, constructor = isi awal. "
                + "Satu class jadi banyak objek dengan data terpisah.");
    }

    public static void encapsulation() {
        Tampilan.judul("Pert. 4 - Encapsulation & Access Modifier");
        Pasien p = DataKlinik.pilihPasien();
        if (p == null) return;

        Tampilan.subjudul("Access modifier di project ini");
        Tampilan.baris("private", "nama, umur, jenisKelamin, keluhan, idPasien");
        Tampilan.baris("public", "getter, setter, tampilkanInfo()");
        Tampilan.info("Akses langsung pasien.nama = error kompilasi.");

        Tampilan.subjudul("Data sekarang");
        Tampilan.baris("Nama", p.getNama());
        Tampilan.baris("Umur", p.getUmur());

        System.out.println();
        int umurBaru = Input.angka(" Umur baru (coba -5 atau 200): ");
        p.setUmur(umurBaru);
        String namaBaru = Input.teksOpsional(" Nama baru (kosongkan untuk uji validasi): ");
        p.setNama(namaBaru);

        Tampilan.subjudul("Hasil akhir");
        Tampilan.baris("Nama", p.getNama());
        Tampilan.baris("Umur", p.getUmur());
        Tampilan.konsep("Setter memvalidasi data. Data tidak valid ditolak, nilai lama tetap aman.");
    }
    
    public static void inheritance() {
        Tampilan.judul("Pert. 5 - Inheritance (extends & super)");
        Pasien p = DataKlinik.daftarPasien.get(0);
        Dokter d = DataKlinik.daftarDokter.get(0);

        Tampilan.info("Pasien extends Orang, Dokter extends Orang.");

        Tampilan.subjudul("1) Member warisan (tidak ditulis ulang di Pasien)");
        Tampilan.baris("p.getNama()", p.getNama());
        Tampilan.baris("p.getUmur()", p.getUmur());

        Tampilan.subjudul("2) super(...) di constructor");
        Tampilan.info("Constructor Pasien memanggil constructor Orang untuk nama, umur, kelamin.");

        Tampilan.subjudul("3) Overriding + super.tampilkanInfo()");
        Tampilan.info("Pasien menambah ID & keluhan, lalu memanggil versi Orang.");
        p.tampilkanInfo();

        Tampilan.subjudul("4) Hubungan is-a");
        Tampilan.baris("Pasien Orang?", (p instanceof Orang));
        Tampilan.baris("Dokter Orang?", (d instanceof Orang));
        Tampilan.konsep("extends mewarisi field & method, super memakai milik induk, "
                + "overriding mengubah perilaku method warisan.");
    }

    public static void polymorphism() {
        Tampilan.judul("Pert. 7 - Polymorphism & Abstract Class");
        List<Orang> semua = new ArrayList<>();
        semua.addAll(DataKlinik.daftarDokter);
        semua.addAll(DataKlinik.daftarPasien);

        Tampilan.info("Orang bersifat abstract (tidak bisa di-new).");
        Tampilan.subjudul("Satu daftar bertipe Orang");
        for (Orang o : semua) {
            Tampilan.baris(o.getClass().getSimpleName(), o.getNama() + " -> " + o.getPeran());
        }

        Tampilan.subjudul("o.tampilkanInfo() untuk semua objek");
        for (Orang o : semua) {
            o.tampilkanInfo();
        }
        Tampilan.konsep("Upcasting ke Orang, abstract method getPeran(), "
                + "polymorphism: satu perintah, hasil berbeda tiap objek.");
    }

    public static void interfaceOverloading() {
        Tampilan.judul("Pert. 7 - Interface & Overloading");
        List<Orang> semua = new ArrayList<>();
        semua.addAll(DataKlinik.daftarDokter);
        semua.addAll(DataKlinik.daftarPasien);

        Tampilan.subjudul("Interface Pelayanan");
        for (Orang o : semua) {
            if (o instanceof Pelayanan) {
                Pelayanan pel = (Pelayanan) o;
                pel.lakukanKegiatan();
                pel.tampilkanJadwal();
            }
        }
        Tampilan.konsep("Pasien memakai default method. Dokter meng-override-nya.");

        Tampilan.subjudul("Interface Peresep (Dokter implements 2 interface)");
        Tampilan.baris("MAKS_OBAT", Peresep.MAKS_JUMLAH_OBAT);
        Dokter dokter = DataKlinik.daftarDokter.get(0);
        try {
            dokter.berikanResep("Siti Rahma", "Paracetamol", 6);
            dokter.berikanResep("Siti Rahma", "Vitamin C", 5, "Diminum sesudah makan");
        } catch (ResepTidakValidException e) {
            Tampilan.gagal(e.getMessage());
        }
        Tampilan.konsep("Overloading. berikanResep() 3 parameter vs 4 parameter.");
    }


    public static void exception() {
        Tampilan.judul("Pert. 8 - Exception Handling");

        Tampilan.subjudul("1) ArrayIndexOutOfBoundsException (multi-catch)");
        try {
            int[] data = {1, 2, 3};
            System.out.println(data[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            Tampilan.gagal("Indeks array di luar jangkauan.");
        } catch (Exception e) {
            Tampilan.gagal("Kesalahan umum: " + e.getMessage());
        } finally {
            Tampilan.info("finally: selesai memproses data.");
        }

        Tampilan.subjudul("2) ArithmeticException");
        try {
            int hasil = 10 / 0;
            System.out.println(hasil);
        } catch (ArithmeticException e) {
            Tampilan.gagal("Tertangkap: " + e.getMessage());
        } finally {
            Tampilan.info("finally: selalu dijalankan.");
        }

        Tampilan.subjudul("3) Custom exception (throw & throws), jumlah obat 25");
        try {
            DataKlinik.daftarDokter.get(0).berikanResep("Siti Rahma", "Amoxicillin", 25);
        } catch (ResepTidakValidException e) {
            Tampilan.gagal("Tertangkap: " + e.getMessage());
        } finally {
            Tampilan.info("finally: proses peresepan selesai.");
        }
        Tampilan.konsep("catch dari spesifik ke umum. finally selalu jalan. "
                + "Custom exception extends Exception.");
    }

    public static void relasi() {
        Tampilan.judul("Pert. 8 - Relasi Antar-Objek");

        Tampilan.subjudul("AGGREGATION: pasien tiap dokter");
        for (Dokter d : DataKlinik.daftarDokter) {
            d.tampilkanDaftarPasien();
        }
        Tampilan.info("Pasien tetap ada walau dokternya tidak ada.");

        Tampilan.subjudul("COMPOSITION: rekam medis tiap pasien");
        for (Pasien p : DataKlinik.daftarPasien) {
            Tampilan.baris("Pasien", p.getNama());
            p.tampilkanRekamMedis();
        }
        Tampilan.info("RekamMedis dibuat di constructor Pasien, tidak ada tanpa pasien.");

        if (!DataKlinik.daftarPasien.isEmpty()) {
            Tampilan.subjudul("ASSOCIATION: dokter memeriksa pasien sesaat");
            DataKlinik.daftarDokter.get(0).periksa(DataKlinik.daftarPasien.get(0), "Pemeriksaan rutin");
        }
        Tampilan.konsep("Association (memakai sesaat), Aggregation (weak ownership), "
                + "Composition (strong ownership).");
    }
}