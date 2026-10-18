package com.mycompany.manajemensistemklinik;

/**
 * Interface kemampuan menulis resep.
 * Method kini mendeklarasikan throws ResepTidakValidException.
 */
public interface Peresep {
    int MAKS_JUMLAH_OBAT = 10; // otomatis public static final

    void berikanResep(String namaPasien, String obat, int jumlah)
            throws ResepTidakValidException;
}