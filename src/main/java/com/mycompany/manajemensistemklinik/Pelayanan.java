package com.mycompany.manajemensistemklinik;

public interface Pelayanan {
    void lakukanKegiatan(); 

    default void tampilkanJadwal() {
        Tampilan.info("Jadwal kegiatan belum ditentukan.");
    }
}