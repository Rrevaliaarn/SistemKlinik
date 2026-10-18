package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

/**
 * Dipakai untuk COMPOSITION: RekamMedis dibuat di dalam constructor Pasien
 * dan tidak punya arti tanpa pasien pemiliknya.
 */
public class RekamMedis {
    private String nomorRekamMedis;
    private List<String> catatan;

    public RekamMedis(String nomorRekamMedis) {
        this.nomorRekamMedis = nomorRekamMedis;
        this.catatan = new ArrayList<>();
        System.out.println("Rekam medis " + nomorRekamMedis + " dibuat.");
    }

    public void tambahCatatan(String isi) {
        catatan.add(isi);
    }

    public void tampilkanRekamMedis() {
        System.out.println("=== Rekam Medis ===");
        System.out.println("Nomor    : " + nomorRekamMedis);
        if (catatan.isEmpty()) {
            System.out.println("(belum ada catatan)");
        } else {
            for (String c : catatan) {
                System.out.println("- " + c);
            }
        }
    }

    public String getNomorRekamMedis() {
        return nomorRekamMedis;
    }
}