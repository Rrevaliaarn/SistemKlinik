package com.mycompany.manajemensistemklinik;

public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" SISTEM MANAJEMEN KLINIK ");
        System.out.println("========================================\n");

        Dokter dokter1 = new Dokter("D001", "Ayu Lestari", 40, "Perempuan", "Dokter Umum", "Senin-Jumat 08.00-14.00");
        Dokter dokter2 = new Dokter("D002", "Budi Santoso", 45, "Laki-laki", "Dokter Gigi", "Selasa & Kamis 13.00-17.00");

        dokter1.tampilkanInfo();
        System.out.println();
        dokter2.tampilkanInfo();
        System.out.println();

        // Composition (P8): RekamMedis otomatis dibuat bersama Pasien
        Pasien pasien1 = new Pasien("P001", "Siti Rahma", 28, "Perempuan", "Demam dan batuk");
        Pasien pasien2 = new Pasien("P002", "Andi Wijaya", 35, "Laki-laki", "Sakit gigi");
        System.out.println();

        pasien1.tampilkanInfo();
        System.out.println();
        pasien2.tampilkanInfo();
        System.out.println();

        JanjiTemu janji1 = new JanjiTemu("JT001", pasien1, dokter1, "15 September 2026", "09.00");
        JanjiTemu janji2 = new JanjiTemu("JT002", pasien2, dokter2, "16 September 2026", "14.00");

        janji1.tampilkanDetail();
        System.out.println();
        janji2.tampilkanDetail();
        System.out.println();

        janji1.selesaikanJanjiTemu();
        janji2.batalkanJanjiTemu();

        System.out.println();
        System.out.println("=== Status Terbaru ===");
        janji1.tampilkanDetail();
        System.out.println();
        janji2.tampilkanDetail();

        System.out.println("\n=== Simulasi Setter dengan Data VALID ===");

        System.out.println("- Mengubah umur pasien1 menjadi 29 (valid):");
        pasien1.setUmur(29);
        System.out.println("  Umur pasien1 sekarang (via getter): " + pasien1.getUmur());

        System.out.println("- Mengubah spesialisasi dokter1 menjadi 'Dokter Anak' (valid):");
        dokter1.setSpesialisasi("Dokter Anak");
        System.out.println("  Spesialisasi dokter1 sekarang (via getter): " + dokter1.getSpesialisasi());

        System.out.println("- Mengubah status janji2 menjadi 'Menunggu' (valid):");
        janji2.setStatus("Menunggu");
        System.out.println("  Status janji2 sekarang (via getter): " + janji2.getStatus());

        System.out.println("\n=== Simulasi Setter dengan Data TIDAK VALID ===");

        System.out.println("- Mencoba mengisi umur pasien1 dengan -5:");
        pasien1.setUmur(-5);
        System.out.println("  Umur pasien1 setelah dicoba diubah (via getter, tetap aman): " + pasien1.getUmur());

        System.out.println("- Mencoba mengisi nama dokter2 dengan string kosong:");
        dokter2.setNama("");
        System.out.println("  Nama dokter2 setelah dicoba diubah (via getter, tetap aman): " + dokter2.getNama());

        System.out.println("- Mencoba mengisi status janji1 dengan 'Terbang ke Bulan':");
        janji1.setStatus("Terbang ke Bulan");
        System.out.println("  Status janji1 setelah dicoba diubah (via getter, tetap aman): " + janji1.getStatus());

        System.out.println("\nData akhir pasien1 (dicek ulang via getter/tampilkanInfo):");
        pasien1.tampilkanInfo();

        // ==================================================
        // PERTEMUAN 6: INHERITANCE (instanceof)
        // ==================================================
        System.out.println("\n========================================");
        System.out.println(" DEMO INHERITANCE & POLYMORPHISM ");
        System.out.println("========================================");

        // Orang orang = new Orang(); // ERROR: abstract class tidak bisa di-new

        // Upcasting: array bertipe Orang menampung Dokter & Pasien
        Orang[] daftarOrang = {dokter1, dokter2, pasien1, pasien2};

        for (Orang o : daftarOrang) {
            System.out.println("\nPeran: " + o.getPeran());
            o.tampilkanInfo();
        }

        System.out.println("\n=== Cek Tipe dengan instanceof ===");
        for (Orang o : daftarOrang) {
            if (o instanceof Dokter) {
                Dokter d = (Dokter) o;
                System.out.println(d.getNama() + " adalah dokter, spesialisasi: " + d.getSpesialisasi());
            } else if (o instanceof Pasien) {
                Pasien p = (Pasien) o;
                System.out.println(p.getNama() + " adalah pasien, keluhan: " + p.getKeluhan());
            }
        }

        // ==================================================
        // PERTEMUAN 7: POLYMORPHISM & ABSTRACTION
        // ==================================================
        System.out.println("\n========================================");
        System.out.println(" DEMO ABSTRACT CLASS & INTERFACE ");
        System.out.println("========================================");

        System.out.println("\n--- Interface Pelayanan (lakukanKegiatan & default method) ---");
        for (Orang o : daftarOrang) {
            if (o instanceof Pelayanan) {
                Pelayanan p = (Pelayanan) o;
                p.lakukanKegiatan();
                p.tampilkanJadwal(); // Pasien: default method, Dokter: override
            }
        }

        System.out.println("\n--- Interface Peresep + Overloading ---");
        Dokter dokterResep = (Dokter) daftarOrang[0]; // downcasting
        try {
            dokterResep.berikanResep("Siti Rahma", "Paracetamol", 6);              // 3 parameter
            dokterResep.berikanResep("Andi Wijaya", "Amoxicillin", 8,              // 4 parameter
                    "Habiskan sesuai anjuran. Maksimal " + Peresep.MAKS_JUMLAH_OBAT + " per resep.");
        } catch (ResepTidakValidException e) {
            System.out.println("Gagal membuat resep: " + e.getMessage());
        }

        // ==================================================
        // PERTEMUAN 8: EXCEPTION HANDLING & RELASI ANTAR-OBJEK
        // ==================================================
        System.out.println("\n========================================");
        System.out.println(" DEMO EXCEPTION & RELASI ANTAR-OBJEK ");
        System.out.println("========================================");

        // Aggregation: Pasien dibuat terpisah, lalu "dititipkan" ke Dokter
        System.out.println("\n--- Aggregation (Dokter - Pasien) ---");
        dokter1.tambahPasien(pasien1);
        dokter1.tambahPasien(pasien2);
        dokter1.tampilkanDaftarPasien();

        // Association: Dokter memakai Pasien sesaat
        System.out.println("\n--- Association (dokter memeriksa pasien) ---");
        dokter1.periksa(pasien1, "Infeksi saluran pernapasan atas");

        // Composition: RekamMedis milik pasien
        System.out.println("\n--- Composition (Pasien - RekamMedis) ---");
        pasien1.tampilkanRekamMedis();

        // try-catch-finally dengan custom exception
        System.out.println("\n--- try-catch-finally: custom exception ---");
        try {
            dokter1.berikanResep("Siti Rahma", "Paracetamol", 6);
            dokter1.berikanResep("Andi Wijaya", "Amoxicillin", 25, "Dosis berlebih"); // melempar exception
            System.out.println("Baris ini tidak dijalankan karena exception di atas.");
        } catch (ResepTidakValidException e) {
            System.out.println("Gagal membuat resep: " + e.getMessage());
        } finally {
            System.out.println("Proses peresepan selesai.");
        }

        // Multi-catch: dari yang paling spesifik ke paling umum
        System.out.println("\n--- Multi-catch (exception bawaan Java) ---");
        try {
            int[] data = {1, 2, 3};
            System.out.println(data[5]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Indeks array di luar jangkauan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan umum: " + e.getMessage());
        } finally {
            System.out.println("Selesai memproses data.");
        }

        try {
            int hasil = 10 / 0;
            System.out.println(hasil);
        } catch (ArithmeticException e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        } finally {
            System.out.println("Blok finally selalu dijalankan.");
        }
    }
}