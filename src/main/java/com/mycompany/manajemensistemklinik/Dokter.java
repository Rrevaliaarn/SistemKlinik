package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

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
        Tampilan.subjudul("Data Dokter " + idDokter);
        super.tampilkanInfo();
        Tampilan.baris("Spesialisasi", spesialisasi);
        Tampilan.baris("Jadwal", jadwalPraktik);
    }

    @Override
    public String getPeran() {
        return "Dokter " + spesialisasi;
    }

    @Override
    public void lakukanKegiatan() {
        Tampilan.info("dr. " + getNama() + " sedang memeriksa pasien (" + spesialisasi + ").");
    }

    @Override
    public void tampilkanJadwal() {
        Tampilan.info("Jadwal praktik dr. " + getNama() + ": " + jadwalPraktik);
    }

    @Override
    public void berikanResep(String namaPasien, String obat, int jumlah)
            throws ResepTidakValidException {
        if (jumlah <= 0 || jumlah > MAKS_JUMLAH_OBAT) {
            throw new ResepTidakValidException("Jumlah " + jumlah + " tidak valid untuk "
                    + namaPasien + ". Jumlah harus 1 - " + MAKS_JUMLAH_OBAT + ".");
        }
        Tampilan.sukses("dr. " + getNama() + " meresepkan " + obat
                + " x" + jumlah + " untuk " + namaPasien + ".");
    }

    // Overloading: nama sama, parameter berbeda
    public void berikanResep(String namaPasien, String obat, int jumlah, String catatan)
            throws ResepTidakValidException {
        berikanResep(namaPasien, obat, jumlah);
        Tampilan.baris("Catatan", catatan);
    }

    // Aggregation
    public void tambahPasien(Pasien pasien) {
        daftarPasien.add(pasien);
    }

    public boolean punyaPasien(Pasien pasien) {
        return daftarPasien.contains(pasien);
    }

    public void tampilkanDaftarPasien() {
        Tampilan.subjudul("Pasien dr. " + getNama());
        if (daftarPasien.isEmpty()) {
            Tampilan.info("Belum ada pasien.");
            return;
        }
        for (int i = 0; i < daftarPasien.size(); i++) {
            Pasien p = daftarPasien.get(i);
            Tampilan.baris("Pasien " + (i + 1), p.getNama() + " (" + p.getKeluhan() + ")");
        }
    }

    public void periksa(Pasien pasien, String diagnosis) {
        Tampilan.sukses("dr. " + getNama() + " memeriksa " + pasien.getNama()
                + ". Diagnosis: " + diagnosis);
        pasien.getRekamMedis().tambahCatatan("Diagnosis: " + diagnosis);
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
            Tampilan.gagal("Spesialisasi tidak boleh kosong. Tidak diubah.");
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