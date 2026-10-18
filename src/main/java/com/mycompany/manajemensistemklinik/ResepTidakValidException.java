package com.mycompany.manajemensistemklinik;

/**
 * CUSTOM EXCEPTION (checked, karena extends Exception).
 * Dilempar saat resep obat tidak valid.
 */
public class ResepTidakValidException extends Exception {
    public ResepTidakValidException(String pesan) {
        super(pesan); // meneruskan pesan ke constructor Exception
    }
}