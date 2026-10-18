package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

public class DataKlinik {
    public static final List<Dokter> daftarDokter = new ArrayList<>();
    public static final List<Pasien> daftarPasien = new ArrayList<>();
    public static final List<JanjiTemu> daftarJanji = new ArrayList<>();

    private DataKlinik() {
    }

    public static void siapkanDataAwal() {
        Tampilan.judul("Menyiapkan data awal");
        Dokter d1 = new Dokter("D001", "Ayu Lestari", 40, "Perempuan",
                "Dokter Umum", "Senin-Jumat 08.00-14.00");
        Dokter d2 = new Dokter("D002", "Budi Santoso", 45, "Laki-laki",
                "Dokter Gigi", "Selasa & Kamis 13.00-17.00");
        daftarDokter.add(d1);
        daftarDokter.add(d2);

        Pasien p1 = new Pasien("P001", "Siti Rahma", 28, "Perempuan", "Demam dan batuk");
        Pasien p2 = new Pasien("P002", "Andi Wijaya", 35, "Laki-laki", "Sakit gigi");
        daftarPasien.add(p1);
        daftarPasien.add(p2);

        daftarJanji.add(new JanjiTemu("JT001", p1, d1, "20 Oktober 2026", "09.00"));
        daftarJanji.add(new JanjiTemu("JT002", p2, d2, "21 Oktober 2026", "14.00"));
        d1.tambahPasien(p1);
        d2.tambahPasien(p2);
        Tampilan.sukses("2 dokter, 2 pasien, 2 janji temu siap dipakai.");
    }

    public static Pasien pilihPasien() {
        if (daftarPasien.isEmpty()) {
            Tampilan.gagal("Belum ada pasien. Daftarkan pasien dulu (menu 1).");
            return null;
        }
        System.out.println();
        for (int i = 0; i < daftarPasien.size(); i++) {
            Pasien p = daftarPasien.get(i);
            System.out.println(" " + (i + 1) + ". " + p.getNama() + " (" + p.getKeluhan() + ")");
        }
        int no = Input.angka(" Pilih pasien: ", 1, daftarPasien.size());
        return daftarPasien.get(no - 1);
    }

    public static Dokter pilihDokter() {
        System.out.println();
        for (int i = 0; i < daftarDokter.size(); i++) {
            Dokter d = daftarDokter.get(i);
            System.out.println(" " + (i + 1) + ". dr. " + d.getNama() + " (" + d.getSpesialisasi() + ")");
        }
        int no = Input.angka(" Pilih dokter: ", 1, daftarDokter.size());
        return daftarDokter.get(no - 1);
    }
}