package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

/**
 * Dokter: extends Orang, implements Pelayanan & Peresep.
 * AGGREGATION : daftarPasien (Pasien dibuat di luar, bisa berdiri sendiri).
 * ASSOCIATION : periksa(Pasien) hanya memakai Pasien sesaat.
 * THROW/THROWS: berikanResep() melempar ResepTidakValidException.
 */
public class Dokter extends Orang implements Pelayanan, Peresep {
    private String idDokter;
    private String spesialisasi;
    private String jadwalPraktik;
    private List<Pasien> daftarPasien; // Aggregation

    public Dokter() {
        super();
        this.idDokter = "-";
        this.spesialisasi = "-";
        this.jadwalPraktik = "-";
        this.daftarPasien = new ArrayList<>();
    }

    public Dokter(String idDokter, String nama, int umur, String jenisKelamin,
                  String spesialisasi, String jadwalPraktik) {
        super(nama, umur, jenisKelamin);
        this.idDokter = idDokter;
        this.spesialisasi = spesialisasi;
        this.jadwalPraktik = jadwalPraktik;
        this.daftarPasien = new ArrayList<>();
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("=== Data Dokter ===");
        System.out.println("ID       : " + idDokter);
        super.tampilkanInfo();
        System.out.println("Spesialis: " + spesialisasi);
        System.out.println("Jadwal   : " + jadwalPraktik);
    }

    @Override
    public String getPeran() {
        return "Dokter " + spesialisasi;
    }

    @Override
    public void lakukanKegiatan() {
        System.out.println("dr. " + getNama() + " sedang memeriksa pasien (" + spesialisasi + ").");
    }

    @Override
    public void tampilkanJadwal() {
        System.out.println("Jadwal praktik dr. " + getNama() + ": " + jadwalPraktik);
    }

    // throws: method berpotensi melempar checked exception
    @Override
    public void berikanResep(String namaPasien, String obat, int jumlah)
            throws ResepTidakValidException {
        if (jumlah <= 0 || jumlah > MAKS_JUMLAH_OBAT) {
            throw new ResepTidakValidException("Jumlah " + jumlah + " tidak valid untuk "
                    + namaPasien + ". Jumlah harus 1 - " + MAKS_JUMLAH_OBAT + ".");
        }
        System.out.println("dr. " + getNama() + " meresepkan " + obat
                + " x" + jumlah + " untuk " + namaPasien);
    }

    // Overloading
    public void berikanResep(String namaPasien, String obat, int jumlah, String catatan)
            throws ResepTidakValidException {
        berikanResep(namaPasien, obat, jumlah);
        System.out.println("Catatan: " + catatan);
    }

    // Aggregation
    public void tambahPasien(Pasien pasien) {
        daftarPasien.add(pasien);
    }

    public void tampilkanDaftarPasien() {
        System.out.println("Daftar pasien dr. " + getNama() + ":");
        for (Pasien p : daftarPasien) {
            System.out.println("- " + p.getNama() + " (" + p.getKeluhan() + ")");
        }
    }

    // Association: Pasien hanya dipakai sesaat, tidak disimpan
    public void periksa(Pasien pasien, String diagnosis) {
        System.out.println("dr. " + getNama() + " memeriksa " + pasien.getNama()
                + " -> diagnosis: " + diagnosis);
        pasien.getRekamMedis().tambahCatatan(diagnosis);
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