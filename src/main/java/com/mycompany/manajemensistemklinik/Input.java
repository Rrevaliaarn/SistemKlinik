package com.mycompany.manajemensistemklinik;

import java.util.Scanner;

public class Input {
    private static final Scanner sc = new Scanner(System.in);

    private Input() {
    }

    public static int angka(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt);
            String teks = sc.nextLine().trim();
            try {
                int nilai = Integer.parseInt(teks);
                if (nilai < min || nilai > max) {
                    Tampilan.gagal("Angka harus antara " + min + " dan " + max + ".");
                    continue;
                }
                return nilai;
            } catch (NumberFormatException e) {
                Tampilan.gagal("Input harus berupa angka. Coba lagi.");
            }
        }
    }

    public static int angka(String prompt) {
        return angka(prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static String teks(String prompt) {
        while (true) {
            System.out.print(prompt);
            String teks = sc.nextLine().trim();
            if (!teks.isEmpty()) {
                return teks;
            }
            Tampilan.gagal("Input tidak boleh kosong.");
        }
    }

    public static String teksOpsional(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    public static String jenisKelamin() {
        while (true) {
            String teks = teks(" Jenis kelamin (Laki-laki/Perempuan): ");
            if (teks.equalsIgnoreCase("Laki-laki")) return "Laki-laki";
            if (teks.equalsIgnoreCase("Perempuan")) return "Perempuan";
            Tampilan.gagal("Harus 'Laki-laki' atau 'Perempuan'.");
        }
    }

    public static void tekanEnter() {
        System.out.print("\n Tekan Enter untuk kembali ke menu...");
        sc.nextLine();
    }
}