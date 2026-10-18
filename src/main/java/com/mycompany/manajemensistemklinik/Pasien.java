package com.mycompany.manajemensistemklinik;

/**
 * Subclass Orang + implementasi interface Pelayanan.
 * COMPOSITION: RekamMedis dibuat di constructor dan bersifat final.
 */
public class Pasien extends Orang implements Pelayanan {
    private String idPasien;
    private String keluhan;
    private final RekamMedis rekamMedis; // Composition

    public Pasien() {
        super();
        this.idPasien = "-";
        this.keluhan = "-";
        this.rekamMedis = new RekamMedis("RM-0000");
    }

    public Pasien(String idPasien, String nama, int umur, String jenisKelamin, String keluhan) {
        super(nama, umur, jenisKelamin);
        this.idPasien = idPasien;
        this.keluhan = keluhan;
        this.rekamMedis = new RekamMedis("RM-" + idPasien); // dibuat bersamaan dengan pasien
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Pasien ===");
        System.out.println("ID       : " + idPasien);
        super.tampilkanInfo();
        System.out.println("Keluhan  : " + keluhan);
    }

    @Override
    public String getPeran() {
        return "Pasien";
    }

    @Override
    public void lakukanKegiatan() {
        System.out.println(getNama() + " sedang menunggu pemeriksaan (keluhan: " + keluhan + ").");
    }

    public void tampilkanRekamMedis() {
        rekamMedis.tampilkanRekamMedis();
    }

    public RekamMedis getRekamMedis() {
        return rekamMedis;
    }

    public String getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(String idPasien) {
        this.idPasien = idPasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }
}