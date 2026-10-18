package com.mycompany.manajemensistemklinik;

public class Pasien extends Orang implements Pelayanan {
    private String idPasien;
    private String keluhan;
    private final RekamMedis rekamMedis;

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
        this.rekamMedis = new RekamMedis("RM-" + idPasien);
    }

    @Override
    public void tampilkanInfo() {
        Tampilan.subjudul("Data Pasien " + idPasien);
        super.tampilkanInfo();
        Tampilan.baris("Keluhan", keluhan);
    }

    @Override
    public String getPeran() {
        return "Pasien";
    }

    @Override
    public void lakukanKegiatan() {
        Tampilan.info(getNama() + " sedang menunggu pemeriksaan (keluhan: " + keluhan + ").");
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