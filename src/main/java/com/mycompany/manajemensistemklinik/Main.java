package com.mycompany.manajemensistemklinik;

public class Main {

    public static void main(String[] args) {
        DataKlinik.siapkanDataAwal();

        boolean jalan = true;
        while (jalan) {
            tampilkanMenu();
            int pilihan = Input.angka(" Pilih menu: ", 0, 15);
            switch (pilihan) {
                case 1: daftarkanPasien(); break;
                case 2: lihatDokter(); break;
                case 3: lihatPasien(); break;
                case 4: buatJanjiTemu(); break;
                case 5: lihatJanjiTemu(); break;
                case 6: ubahStatusJanji(); break;
                case 7: periksaDanResep(); break;
                case 8: lihatRekamMedis(); break;
                case 9: DemoKonsep.classObject(); break;
                case 10: DemoKonsep.encapsulation(); break;
                case 11: DemoKonsep.inheritance(); break;
                case 12: DemoKonsep.polymorphism(); break;
                case 13: DemoKonsep.interfaceOverloading(); break;
                case 14: DemoKonsep.exception(); break;
                case 15: DemoKonsep.relasi(); break;
                case 0:
                    System.out.println("\n Terima kasih. Sampai jumpa!");
                    jalan = false;
                    break;
            }
            if (jalan) {
                Input.tekanEnter();
            }
        }
    }

    private static void tampilkanMenu() {
        Tampilan.judul("Sistem Manajemen Klinik");
        System.out.println(" FITUR KLINIK");
        System.out.println("   1. Daftarkan pasien");
        System.out.println("   2. Lihat daftar dokter");
        System.out.println("   3. Lihat daftar pasien");
        System.out.println("   4. Buat janji temu");
        System.out.println("   5. Lihat daftar janji temu");
        System.out.println("   6. Ubah status janji temu");
        System.out.println("   7. Periksa pasien & buat resep");
        System.out.println("   8. Lihat rekam medis pasien");
        System.out.println("   0. Keluar");
        System.out.println("-".repeat(46));
    }

    // ---------------- Fitur klinik ----------------

    private static void daftarkanPasien() {
        Tampilan.judul("Daftarkan pasien");
        String nama = Input.teks(" Nama          : ");
        int umur = Input.angka(" Umur          : ", 0, 130);
        String kelamin = Input.jenisKelamin();
        String keluhan = Input.teks(" Keluhan       : ");

        String id = String.format("P%03d", DataKlinik.daftarPasien.size() + 1);
        Pasien pasien = new Pasien(id, nama, umur, kelamin, keluhan);
        DataKlinik.daftarPasien.add(pasien);
        Tampilan.sukses("Pasien berhasil didaftarkan dengan ID " + id + ".");
        Tampilan.konsep("Composition. RekamMedis dibuat otomatis di constructor Pasien.");
    }

    private static void lihatDokter() {
        Tampilan.judul("Daftar dokter");
        for (Dokter d : DataKlinik.daftarDokter) {
            d.tampilkanInfo();
        }
    }

    private static void lihatPasien() {
        Tampilan.judul("Daftar pasien");
        if (DataKlinik.daftarPasien.isEmpty()) {
            Tampilan.info("Belum ada pasien terdaftar.");
            return;
        }
        for (Pasien p : DataKlinik.daftarPasien) {
            p.tampilkanInfo();
        }
    }

    private static void buatJanjiTemu() {
        Tampilan.judul("Buat janji temu");
        Pasien pasien = DataKlinik.pilihPasien();
        if (pasien == null) return;
        Dokter dokter = DataKlinik.pilihDokter();
        String tanggal = Input.teks(" Tanggal (mis. 22 Oktober 2026): ");
        String jam = Input.teks(" Jam (mis. 10.00): ");

        String id = String.format("JT%03d", DataKlinik.daftarJanji.size() + 1);
        JanjiTemu janji = new JanjiTemu(id, pasien, dokter, tanggal, jam);
        DataKlinik.daftarJanji.add(janji);

        if (!dokter.punyaPasien(pasien)) {
            dokter.tambahPasien(pasien);
        }
        Tampilan.sukses("Janji temu berhasil dibuat.");
        janji.tampilkanDetail();
        Tampilan.konsep("Aggregation. Pasien dibuat terpisah, lalu dititipkan ke Dokter.");
    }

    private static void lihatJanjiTemu() {
        Tampilan.judul("Daftar janji temu");
        if (DataKlinik.daftarJanji.isEmpty()) {
            Tampilan.info("Belum ada janji temu.");
            return;
        }
        for (JanjiTemu j : DataKlinik.daftarJanji) {
            j.tampilkanDetail();
        }
    }

    private static void ubahStatusJanji() {
        Tampilan.judul("Ubah status janji temu");
        if (DataKlinik.daftarJanji.isEmpty()) {
            Tampilan.info("Belum ada janji temu.");
            return;
        }
        System.out.println();
        for (int i = 0; i < DataKlinik.daftarJanji.size(); i++) {
            JanjiTemu j = DataKlinik.daftarJanji.get(i);
            System.out.println(" " + (i + 1) + ". " + j.getIdJanjiTemu() + " - "
                    + j.getPasien().getNama() + " (" + j.getStatus() + ")");
        }
        int no = Input.angka(" Pilih janji temu: ", 1, DataKlinik.daftarJanji.size());
        JanjiTemu janji = DataKlinik.daftarJanji.get(no - 1);
        int aksi = Input.angka(" 1 = Selesaikan, 2 = Batalkan: ", 1, 2);
        if (aksi == 1) {
            janji.selesaikanJanjiTemu();
        } else {
            janji.batalkanJanjiTemu();
        }
    }

    private static void periksaDanResep() {
        Tampilan.judul("Periksa pasien & resep");
        Pasien pasien = DataKlinik.pilihPasien();
        if (pasien == null) return;
        Dokter dokter = DataKlinik.pilihDokter();

        String diagnosis = Input.teks(" Diagnosis: ");
        System.out.println();
        dokter.periksa(pasien, diagnosis);
        Tampilan.konsep("Association. Dokter hanya memakai Pasien sesaat.");

        String jawab = Input.teks("\n Buat resep? (y/n): ");
        if (!jawab.equalsIgnoreCase("y")) return;

        String obat = Input.teks(" Nama obat: ");
        int jumlah = Input.angka(" Jumlah (maks " + Peresep.MAKS_JUMLAH_OBAT
                + ", coba 25 untuk uji exception): ");
        String catatan = Input.teksOpsional(" Catatan (kosongkan jika tidak ada): ");

        System.out.println();
        try {
            if (catatan.isEmpty()) {
                dokter.berikanResep(pasien.getNama(), obat, jumlah);
            } else {
                dokter.berikanResep(pasien.getNama(), obat, jumlah, catatan);
            }
            pasien.getRekamMedis().tambahCatatan("Resep: " + obat + " x" + jumlah);
            Tampilan.sukses("Resep tercatat di rekam medis.");
        } catch (ResepTidakValidException e) {
            Tampilan.gagal("Resep ditolak. " + e.getMessage());
        } finally {
            Tampilan.info("Proses peresepan selesai.");
        }
        Tampilan.konsep("try-catch-finally dengan custom exception.");
    }

    private static void lihatRekamMedis() {
        Tampilan.judul("Rekam medis pasien");
        Pasien pasien = DataKlinik.pilihPasien();
        if (pasien == null) return;
        pasien.tampilkanRekamMedis();
    }
}