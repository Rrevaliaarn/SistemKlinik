package com.mycompany.manajemensistemklinik;

/**
 * Superclass (class induk): menyimpan atribut & perilaku yang
 * dimiliki bersama oleh Pasien dan Dokter.
 */
public class Orang {
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

    public void tampilkanInfo() {
        System.out.println("Nama     : " + nama);
        System.out.println("Umur     : " + umur + " tahun");
        System.out.println("Kelamin  : " + jenisKelamin);
    }

    public String getPeran() {
        return "Orang";
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong. Nama tidak diubah.");
            return;
        }
        this.nama = nama;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        if (umur < 0 || umur > 130) {
            System.out.println("Umur tidak valid. Umur tidak diubah.");
            return;
        }
        this.umur = umur;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (!jenisKelamin.equalsIgnoreCase("Laki-laki") && !jenisKelamin.equalsIgnoreCase("Perempuan")) {
            System.out.println("Jenis kelamin harus 'Laki-laki' atau 'Perempuan'. Tidak diubah.");
            return;
        }
        this.jenisKelamin = jenisKelamin;
    }
}