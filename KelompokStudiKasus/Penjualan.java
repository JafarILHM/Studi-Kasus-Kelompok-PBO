package KelompokStudiKasus;

class Penjualan {
    private String namaPelanggan;
    private int idBuku;
    private int jumlahBuku;
    private double totalHarga;

    public Penjualan(String namaPelanggan, int idBuku, int jumlahBuku, double totalHarga) {
        this.namaPelanggan = namaPelanggan;
        this.idBuku = idBuku;
        this.jumlahBuku = jumlahBuku;
        this.totalHarga = totalHarga;
    }

    public void tampilkanDetailPenjualan() {
        System.out.printf("\n%-20s %-10d %-10d %-10.2f\n", namaPelanggan, idBuku, jumlahBuku, totalHarga);
    }

    public double getTotalHarga() {
        return totalHarga;
    }
}
