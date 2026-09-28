package com.mycompany.manajemensistemklinik;

/**
 * Subclass dari Orang (Inheritance): nama, umur, jenisKelamin
 * diwarisi dari Orang, jadi tidak perlu ditulis ulang.
 */
public class Pasien extends Orang {
    private String idPasien;
    private String keluhan;

    public Pasien() {
        super(); // memanggil constructor Orang()
        this.idPasien = "-";
        this.keluhan = "-";
    }

    public Pasien(String idPasien, String nama, int umur, String jenisKelamin, String keluhan) {
        super(nama, umur, jenisKelamin); // memanggil constructor Orang(...)
        this.idPasien = idPasien;
        this.keluhan = keluhan;
    }

    // Overriding: mengubah perilaku method milik Orang
    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Pasien ===");
        System.out.println("ID       : " + idPasien);
        super.tampilkanInfo(); // pakai method induk untuk nama, umur, kelamin
        System.out.println("Keluhan  : " + keluhan);
    }

    @Override
    public String getPeran() {
        return "Pasien";
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