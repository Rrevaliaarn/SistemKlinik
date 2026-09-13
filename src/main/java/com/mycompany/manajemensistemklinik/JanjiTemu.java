/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.manajemensistemklinik;

/**
 *
 * @author HYPE
 */
public class JanjiTemu {
    private String idJanjiTemu;
    private Pasien pasien;   
    private Dokter dokter;   
    private String tanggal;
    private String jamPraktik;
    private String status;   
    
    public JanjiTemu() {
        this.idJanjiTemu = "-";
        this.pasien = new Pasien();
        this.dokter = new Dokter();
        this.tanggal = "-";
        this.jamPraktik = "-";
        this.status = "Menunggu";
    }

    public JanjiTemu(String idJanjiTemu, Pasien pasien, Dokter dokter, String tanggal, String jamPraktik) {
        this.idJanjiTemu = idJanjiTemu;
        this.pasien = pasien;
        this.dokter = dokter;
        this.tanggal = tanggal;
        this.jamPraktik = jamPraktik;
        this.status = "Menunggu";
    }

    public void tampilkanDetail() {
        System.out.println("=== Detail Janji Temu ===");
        System.out.println("ID Janji Temu : " + idJanjiTemu);
        System.out.println("Pasien        : " + pasien.getNama());
        System.out.println("Dokter        : dr. " + dokter.getNama() + " (" + dokter.getSpesialisasi() + ")");
        System.out.println("Tanggal       : " + tanggal);
        System.out.println("Jam           : " + jamPraktik);
        System.out.println("Status        : " + status);
    }

    public void selesaikanJanjiTemu() {
        this.status = "Selesai";
        System.out.println("Janji temu " + idJanjiTemu + " telah diselesaikan.");
    }

    public void batalkanJanjiTemu() {
        this.status = "Dibatalkan";
        System.out.println("Janji temu " + idJanjiTemu + " telah dibatalkan.");
    }

    public String getIdJanjiTemu() {
        return idJanjiTemu;
    }

    public void setIdJanjiTemu(String idJanjiTemu) {
        this.idJanjiTemu = idJanjiTemu;
    }

    public Pasien getPasien() {
        return pasien;
    }

    public void setPasien(Pasien pasien) {
        this.pasien = pasien;
    }

    public Dokter getDokter() {
        return dokter;
    }

    public void setDokter(Dokter dokter) {
        this.dokter = dokter;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJamPraktik() {
        return jamPraktik;
    }

    public void setJamPraktik(String jamPraktik) {
        this.jamPraktik = jamPraktik;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        if (!status.equalsIgnoreCase("Menunggu")
                && !status.equalsIgnoreCase("Selesai")
                && !status.equalsIgnoreCase("Dibatalkan")) {
            System.out.println("Status tidak valid. Gunakan: Menunggu, Selesai, atau Dibatalkan.");
            return;
        }
        this.status = status;
    }
}
