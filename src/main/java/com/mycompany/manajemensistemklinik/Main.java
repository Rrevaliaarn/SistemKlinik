/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemensistemklinik;

/**
 *
 * @author HYPE
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println(" SISTEM MANAJEMEN KLINIK - FONDASI AWAL ");
        System.out.println("========================================\n");

        Dokter dokter1 = new Dokter("D001", "Ayu Lestari", "Dokter Umum", "Senin-Jumat 08.00-14.00");
        Dokter dokter2 = new Dokter("D002", "Budi Santoso", "Dokter Gigi", "Selasa & Kamis 13.00-17.00");

        dokter1.tampilkanInfo();
        System.out.println();
        dokter2.tampilkanInfo();
        System.out.println();

        Pasien pasien1 = new Pasien("P001", "Siti Rahma", 28, "Perempuan", "Demam dan batuk");
        Pasien pasien2 = new Pasien("P002", "Andi Wijaya", 35, "Laki-laki", "Sakit gigi");

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

        System.out.println("\n=== Demonstrasi Encapsulation (Validasi Data) ===");

        System.out.println("- Mencoba mengisi umur pasien1 dengan -5:");
        pasien1.setUmur(-5);

        System.out.println("- Mencoba mengisi nama dokter2 dengan string kosong:");
        dokter2.setNama("");

        System.out.println("- Mencoba mengisi status janji1 dengan 'Terbang ke Bulan':");
        janji1.setStatus("Terbang ke Bulan");

        System.out.println("\nData pasien1 setelah percobaan input tidak valid (tetap aman):");
        pasien1.tampilkanInfo();
    }
}