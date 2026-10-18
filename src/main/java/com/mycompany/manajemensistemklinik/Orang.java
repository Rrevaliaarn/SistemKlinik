package com.mycompany.manajemensistemklinik;

public abstract class Orang {
    private String nama;
    private int umur;
    private String jenisKelamin;

    public Orang() {
        this.nama = "Belum diisi";
        this.umur = 0;
        this.jenisKelamin = "-";
    }

    public Orang(String nama, int umur, String jenisKelamin) {
        this.nama = nama;
        this.umur = umur;
        this.jenisKelamin = jenisKelamin;
    }

    // Abstract method: wajib di-override oleh subclass
    public abstract String getPeran();

    // Method konkret: dipakai bersama oleh semua subclass
    public void tampilkanInfo() {
        Tampilan.baris("Nama", nama);
        Tampilan.baris("Umur", umur + " tahun");
        Tampilan.baris("Jenis kelamin", jenisKelamin);
        Tampilan.baris("Peran", getPeran()); // polimorfis
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            Tampilan.gagal("Nama tidak boleh kosong. Nama tidak diubah.");
            return;
        }
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur < 0 || umur > 130) {
            Tampilan.gagal("Umur tidak valid (harus 0-130). Umur tidak diubah.");
            return;
        }
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (jenisKelamin == null
                || (!jenisKelamin.equalsIgnoreCase("Laki-laki")
                && !jenisKelamin.equalsIgnoreCase("Perempuan"))) {
            Tampilan.gagal("Jenis kelamin harus 'Laki-laki' atau 'Perempuan'. Tidak diubah.");
            return;
        }
        this.jenisKelamin = jenisKelamin;
    }
}