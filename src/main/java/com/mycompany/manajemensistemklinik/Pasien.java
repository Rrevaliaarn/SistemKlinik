/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemensistemklinik;

/**
 *
 * @author HYPE
 */
public class Pasien {
    // ===== Field (atribut/data yang dimiliki setiap object Pasien) =====
    private String idPasien;
    private String nama;
    private int umur;
    private String jenisKelamin;
    private String keluhan;

    public Pasien() {
        this.idPasien = "-";
        this.nama = "Belum diisi";
        this.umur = 0;
        this.jenisKelamin = "-";
        this.keluhan = "-";
    }

    public Pasien(String idPasien, String nama, int umur, String jenisKelamin, String keluhan) {
        this.idPasien = idPasien;
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
        this.keluhan = keluhan;
    }

    public void tampilkanInfo() {
        System.out.println("=== Data Pasien ===");
        System.out.println("ID       : " + idPasien);
        System.out.println("Nama     : " + nama);
        System.out.println("Umur     : " + umur + " tahun");
        System.out.println("Kelamin  : " + jenisKelamin);
        System.out.println("Keluhan  : " + keluhan);
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong. Nama tidak diubah.");
            return;
        }
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        // Encapsulation: menjaga agar nilai umur selalu valid (tidak negatif/tidak wajar)
        if (umur < 0 || umur > 130) {
            System.out.println("Umur tidak valid. Umur tidak diubah.");
            return;
        }
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (!jenisKelamin.equalsIgnoreCase("Laki-laki") && !jenisKelamin.equalsIgnoreCase("Perempuan")) {
            System.out.println("Jenis kelamin harus 'Laki-laki' atau 'Perempuan'. Tidak diubah.");
            return;
        }
        this.jenisKelamin = jenisKelamin;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}
