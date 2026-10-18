package com.mycompany.manajemensistemklinik;

import java.util.ArrayList;
import java.util.List;

public class RekamMedis {
    private String nomorRekamMedis;
    private List<String> catatan;

    public RekamMedis(String nomorRekamMedis) {
        this.nomorRekamMedis = nomorRekamMedis;
        this.catatan = new ArrayList<>();
        Tampilan.info("Rekam medis " + nomorRekamMedis + " dibuat.");
    }

    public void tambahCatatan(String isi) {
        catatan.add(isi);
    }

    public void tampilkanRekamMedis() {
        Tampilan.subjudul("Rekam Medis " + nomorRekamMedis);
        if (catatan.isEmpty()) {
            Tampilan.info("Belum ada catatan.");
            return;
        }
        for (int i = 0; i < catatan.size(); i++) {
            Tampilan.baris("Catatan " + (i + 1), catatan.get(i));
        }
    }

    public String getNomorRekamMedis() {
        return nomorRekamMedis;
    }
}