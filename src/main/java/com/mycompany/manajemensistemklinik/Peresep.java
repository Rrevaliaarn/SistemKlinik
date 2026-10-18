package com.mycompany.manajemensistemklinik;

public interface Peresep {
    int MAKS_JUMLAH_OBAT = 10; 

    void berikanResep(String namaPasien, String obat, int jumlah)
            throws ResepTidakValidException;
}