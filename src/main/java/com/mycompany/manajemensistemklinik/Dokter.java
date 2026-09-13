/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemensistemklinik;

/**
 *
 * @author HYPE
 */
public class Dokter {
    private String idDokter;
    private String nama;
    private String spesialisasi;
    private String jadwalPraktik;

    public Dokter() {
        this.idDokter = "-";
        this.nama = "Belum diisi";
        this.spesialisasi = "Umum";
        this.jadwalPraktik = "Belum ditentukan";
    }

    public Dokter(String idDokter, String nama, String spesialisasi, String jadwalPraktik) {
        this.idDokter = idDokter;
        this.nama = nama;
        this.spesialisasi = spesialisasi;
        this.jadwalPraktik = jadwalPraktik;
    }

    public void tampilkanInfo() {
        System.out.println("=== Data Dokter ===");
        System.out.println("ID            : " + idDokter);
        System.out.println("Nama          : dr. " + nama);
        System.out.println("Spesialisasi  : " + spesialisasi);
        System.out.println("Jadwal        : " + jadwalPraktik);
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama dokter tidak boleh kosong. Nama tidak diubah.");
            return;
        }
        this.nama = nama;
    }

    public String getSpesialisasi() {
        return spesialisasi;
    }

    public void setSpesialisasi(String spesialisasi) {
        if (spesialisasi == null || spesialisasi.trim().isEmpty()) {
            System.out.println("Spesialisasi tidak boleh kosong. Tidak diubah.");
            return;
        }
        this.spesialisasi = spesialisasi;
    }

    public String getJadwalPraktik() {
        return jadwalPraktik;
    }

    public void setJadwalPraktik(String jadwalPraktik) {
        this.jadwalPraktik = jadwalPraktik;
    }
}
