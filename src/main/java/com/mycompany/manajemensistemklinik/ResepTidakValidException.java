package com.mycompany.manajemensistemklinik;

public class ResepTidakValidException extends Exception {
    public ResepTidakValidException(String pesan) {
        super(pesan);
    }
}