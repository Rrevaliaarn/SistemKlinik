package com.mycompany.manajemensistemklinik;

public interface Pelayanan {
    void lakukanKegiatan();

    default void tampilkanJadwal() {
        System.out.println("Jadwal kegiatan belum ditentukan.");
    }
}