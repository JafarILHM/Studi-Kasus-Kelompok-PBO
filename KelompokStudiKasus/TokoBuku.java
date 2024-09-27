package KelompokStudiKasus;

import java.util.Scanner;

class TokoBuku {
    private Buku[] daftarBuku = new Buku[100]; 
    private Penjualan[] daftarPenjualan = new Penjualan[100]; 
    private double totalPenjualan = 0.0;
    private Scanner scanner = new Scanner(System.in); 
    private int jumlahBuku = 0; 
    private int jumlahPenjualan = 0; 

    // Menambah buku baru ke daftar
    public void tambahBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku++] = buku;
            System.out.println("[!] Buku baru berhasil ditambahkan.");
        } else {
            System.out.println("[!] Kapasitas buku sudah penuh.");
        }
    }

    // Menampilkan daftar buku 
    public void tampilkanDaftarBuku() {
        System.out.println("\n===============================================================================");
        System.out.printf("%-10s %-30s %-20s %-10s %-10s\n", "ID", "Judul", "Penulis", "Harga", "Stok");
        System.out.println("===============================================================================");
        for (int i = 0; i < jumlahBuku; i++) {
            Buku buku = daftarBuku[i];
            System.out.printf("%-10d %-30s %-20s %-10.2f %-10d\n", buku.getIdBuku(), buku.getJudul(), buku.getPenulis(), buku.getHarga(), buku.getStok());
        }
    }

    // Mencatat penjualan buku
    public void jualBuku(String namaPelanggan, int idBuku, int jumlahBuku) {
        for (int i = 0; i < jumlahBuku; i++) {
            Buku buku = daftarBuku[i];
            if (buku.getIdBuku() == idBuku) {
                if (buku.getStok() >= jumlahBuku) {
                    buku.setStok(buku.getStok() - jumlahBuku);
                    double totalHarga = buku.getHarga() * jumlahBuku;
                    Penjualan penjualan = new Penjualan(namaPelanggan, idBuku, jumlahBuku, totalHarga);
                    
                    if (jumlahPenjualan < daftarPenjualan.length) {
                        daftarPenjualan[jumlahPenjualan++] = penjualan;
                        totalPenjualan += totalHarga;
                        System.out.println("\n[!] Penjualan berhasil dicatat.");
                    } else {
                        System.out.println("\n[!] Kapasitas penjualan sudah penuh.");
                    }
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
        for (int i = 0; i < jumlahPenjualan; i++) {
            daftarPenjualan[i].tampilkanDetailPenjualan();
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
