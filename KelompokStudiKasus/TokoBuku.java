package KelompokStudiKasus;

import java.util.ArrayList;
import java.util.List;

class TokoBuku {
    private List<Buku> daftarBuku = new ArrayList<>();
    private List<Penjualan> daftarPenjualan = new ArrayList<>();
    private double totalPenjualan = 0.0;

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
        System.out.println("Total Penjualan: " + totalPenjualan);
    }
}
