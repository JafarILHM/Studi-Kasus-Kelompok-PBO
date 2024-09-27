package KelompokStudiKasus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class TokoBuku {
    private List<Buku> daftarBuku = new ArrayList<>();
    private List<Penjualan> daftarPenjualan = new ArrayList<>();
    private double totalPenjualan = 0.0;
    private Scanner scanner = new Scanner(System.in); 
    
    // Menambah buku baru ke daftar
    public void tambahBuku(Buku buku) {
        daftarBuku.add(buku);
        System.out.println("[!] Buku baru berhasil ditambahkan.");
    }

    // Menampilkan daftar buku 
    public void tampilkanDaftarBuku() {
    	System.out.println("\n===============================================================================");
        System.out.printf("%-10s %-30s %-20s %-10s %-10s\n", "ID", "Judul", "Penulis", "Harga", "Stok");
        System.out.println("===============================================================================");
        for (Buku buku : daftarBuku) {
            System.out.printf("%-10d %-30s %-20s %-10.2f %-10d\n", buku.getIdBuku(), buku.getJudul(), buku.getPenulis(), buku.getHarga(), buku.getStok());
        }
    }

    // Mencatat penjualan buku
    public void jualBuku(String namaPelanggan, int idBuku, int jumlahBuku) {
        for (Buku buku : daftarBuku) {
            if (buku.getIdBuku() == idBuku) {
                if (buku.getStok() >= jumlahBuku) {
                    buku.setStok(buku.getStok() - jumlahBuku);
                    double totalHarga = buku.getHarga() * jumlahBuku;
                    Penjualan penjualan = new Penjualan(namaPelanggan, idBuku, jumlahBuku, totalHarga);
                    daftarPenjualan.add(penjualan);
                    totalPenjualan += totalHarga;
                    System.out.println("\n[!] Penjualan berhasil dicatat.");
                } else {
                    System.out.println("\n[!] Stok buku tidak mencukupi.");
                }
                return;
            }
        }
        System.out.println("\n[!] Buku dengan ID tersebut tidak ditemukan.");
    }

    // Menampilkan daftar penjualan 
    public void tampilkanDaftarPenjualan() {
    	System.out.println("\n===============================================================================");
        System.out.printf("%-20s %-10s %-10s %-10s\n", "Nama Pelanggan", "ID Buku", "Jumlah", "Total Harga");
        System.out.println("===============================================================================");
        for (Penjualan penjualan : daftarPenjualan) {
            penjualan.tampilkanDetailPenjualan();
        }
    }

    // Menampilkan total penjualan 
    public void tampilkanTotalPenjualan() {
    	System.out.print("\n");
        System.out.println("Total Penjualan: " + totalPenjualan);
    }

    // Metode untuk menerima input buku baru dari user
    public void inputBukuBaru() {
        System.out.print("\nMasukkan ID Buku: ");
        int id = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Masukkan Judul Buku: ");
        String judul = scanner.nextLine();
        System.out.print("Masukkan Penulis: ");
        String penulis = scanner.nextLine();
        System.out.print("Masukkan Harga: ");
        double harga = scanner.nextDouble();
        System.out.print("Masukkan Stok: ");
        int stok = scanner.nextInt();
        
        // Menambahkan buku baru ke daftar
        tambahBuku(new Buku(id, judul, penulis, harga, stok));
    }

    // Metode untuk menerima input penjualan dari pelanggan
    public void prosesPenjualan() {
        System.out.print("\nMasukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();
        System.out.print("Masukkan ID Buku yang Dibeli: ");
        int idBuku = scanner.nextInt();
        System.out.print("Masukkan Jumlah Buku yang Dibeli: ");
        int jumlahBuku = scanner.nextInt();

        jualBuku(namaPelanggan, idBuku, jumlahBuku);
    }
}
