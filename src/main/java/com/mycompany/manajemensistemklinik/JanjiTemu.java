package com.mycompany.manajemensistemklinik;

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
        Tampilan.subjudul("Janji Temu " + idJanjiTemu);
        Tampilan.baris("Pasien", pasien.getNama());
        Tampilan.baris("Dokter", "dr. " + dokter.getNama() + " (" + dokter.getSpesialisasi() + ")");
        Tampilan.baris("Tanggal", tanggal);
        Tampilan.baris("Jam", jamPraktik);
        Tampilan.baris("Status", status);
    }

    public void selesaikanJanjiTemu() {
        this.status = "Selesai";
        Tampilan.sukses("Janji temu " + idJanjiTemu + " telah diselesaikan.");
    }

    public void batalkanJanjiTemu() {
        this.status = "Dibatalkan";
        Tampilan.sukses("Janji temu " + idJanjiTemu + " telah dibatalkan.");
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
            Tampilan.gagal("Status tidak valid. Gunakan: Menunggu, Selesai, atau Dibatalkan.");
            return;
        }
        this.status = status;
    }
}