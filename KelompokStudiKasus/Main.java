package KelompokStudiKasus;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TokoBuku tokoBuku = new TokoBuku();

        // Menambahkan beberapa buku di awal
        tokoBuku.tambahBuku(new Buku(1, "Pemrograman Java", "Jafaruddin Ilham", 100000, 10));
        tokoBuku.tambahBuku(new Buku(2, "Algoritma & Struktur Data", "Raffi Naufal Fahreza", 120000, 5));

        int pilihan = 0;
        do {
        	System.out.println("\n===============================================================================");
            System.out.println("Aplikasi Manajemen Toko Buku");
            System.out.println("===============================================================================");
            System.out.println("1. Tambah Buku");
            System.out.println("2. Lihat Daftar Buku");
            System.out.println("3. Jual Buku");
            System.out.println("4. Lihat Daftar Penjualan");
            System.out.println("5. Lihat Total Penjualan");
            System.out.println("6. Keluar");
            System.out.println("===============================================================================");
            System.out.print("Pilih opsi: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();  

            switch (pilihan) {
                case 1:
                    tokoBuku.inputBukuBaru(); 
                    break;
                case 2:
                    tokoBuku.tampilkanDaftarBuku();
                    break;
                case 3:
                    tokoBuku.prosesPenjualan(); 
                    break;
                case 4:
                    tokoBuku.tampilkanDaftarPenjualan();
                    break;
                case 5:
                    tokoBuku.tampilkanTotalPenjualan();
                    break;
                case 6:
                	System.out.println("\nTerimakasih atas kunjungannya ke Toko buku ini.");
                    System.out.println("\n[!] Keluar dari aplikasi.");
                    break;
                default:
                    System.out.println("\n[!] Pilihan tidak valid.");
            }
        } while (pilihan != 6);

        scanner.close();
    }
}
