package com.mycompany.manajemensistemklinik;

public class Tampilan {
    private static final int LEBAR = 46;

    private Tampilan() {
    }

    public static void judul(String teks) {
        System.out.println();
        System.out.println("=".repeat(LEBAR));
        System.out.println(" " + teks.toUpperCase());
        System.out.println("=".repeat(LEBAR));
    }

    public static void subjudul(String teks) {
        System.out.println("\n-- " + teks + " --");
    }

    public static void baris(String label, Object nilai) {
        System.out.printf(" %-13s: %s%n", label, nilai);
    }

    public static void info(String teks) {
        System.out.println(" [INFO]  " + teks);
    }

    public static void sukses(String teks) {
        System.out.println(" [OK]    " + teks);
    }

    public static void gagal(String teks) {
        System.out.println(" [GAGAL] " + teks);
    }

    public static void konsep(String teks) {
        System.out.println("\n >> KONSEP: " + teks);
    }
}