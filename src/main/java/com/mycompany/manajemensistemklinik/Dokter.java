package com.mycompany.manajemensistemklinik;

/**
 * Subclass dari Orang (Inheritance).
 */
public class Dokter extends Orang {
    private String idDokter;
    private String spesialisasi;
    private String jadwalPraktik;

    public Dokter() {
        super();
        this.idDokter = "-";
        this.spesialisasi = "Umum";
        this.jadwalPraktik = "Belum ditentukan";
    }

    public Dokter(String idDokter, String nama, int umur, String jenisKelamin,
                  String spesialisasi, String jadwalPraktik) {
        super(nama, umur, jenisKelamin);
        this.idDokter = idDokter;
        this.spesialisasi = spesialisasi;
        this.jadwalPraktik = jadwalPraktik;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Dokter ===");
        System.out.println("ID            : " + idDokter);
        super.tampilkanInfo();
        System.out.println("Spesialisasi  : " + spesialisasi);
        System.out.println("Jadwal        : " + jadwalPraktik);
    }

    @Override
    public String getPeran() {
        return "Dokter";
    }

    public String getIdDokter() {
        return idDokter;
    }

    public void setIdDokter(String idDokter) {
        this.idDokter = idDokter;
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