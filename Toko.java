// Maziya Ats Tsaqofi
// 21 April 2025
// MID Exam - Pemrograman Berorientasi Objek

public class Toko extends Barang {

    // Method untuk menampilkan data transaksi barang
    void tampilData() {
        System.out.println("\nDATA BARANG");
        System.out.println("No Nota        : " + noNota);
        System.out.println("Barcode        : " + barCode);
        System.out.println("Nama Barang    : " + nmBarang);
        System.out.println("Harga Beli     : Rp " + hrgBeli);
        System.out.println("Harga Jual     : Rp " + hrgJual);
        System.out.println("Jumlah         : " + jumlah);
        System.out.println("Total          : Rp " + total);
        System.out.println("Metode Bayar   : " + metodeBayar);

        if (metodeBayar.equals("tempo")) {
            System.out.println("Lama Tempo     : " + lamaTempo + " hari");
        }

        System.out.printf("PPN (11%%)       : Rp %.2f\n", ppn);
        System.out.printf("Bunga (2.5%%)    : Rp %.2f\n", bunga);
        System.out.printf("Bea Kartu       : Rp %.2f\n", beaKartu);
        System.out.printf("TOTAL BAYAR     : Rp %.2f\n", grandTotal);
    }

    // Method untuk menampilkan daftar semua barang
    static void daftarBarang(Toko[] dataBarang) {
        System.out.println("\nDAFTAR BARANG");
        System.out.printf("%-12s %-10s %-15s %-12s %-12s %-8s %-12s%n",
                "No Nota", "Barcode", "Nama", "Hrg Beli", "Hrg Jual", "Jumlah", "Total");
        System.out.println("--------------------------------------------------------------------------");

        for (Toko b : dataBarang) {
            System.out.printf("%-12s %-10s %-15s %-12.2f %-12.2f %-8d %-12.2f%n",
                    b.noNota, b.barCode, b.nmBarang, b.hrgBeli, b.hrgJual, b.jumlah, b.total);
        }
    }

    void tentukanSouvenir() {
        if (metodeBayar.equals("cash")) {
            if (grandTotal >= 100000 && grandTotal <= 500000) {
                souvenir = "Mangkok Lucu";
            } else if (grandTotal > 500000 && grandTotal <= 750000) {
                souvenir = "Payung Besar";
            } else if (grandTotal > 750000 && grandTotal <= 1000000) {
                souvenir = "Tas Imut";
            } else if (grandTotal > 1000000) {
                souvenir = "Voucher Belanja 100rb";
            } else {
                souvenir = "-";
            }
        } else {
            souvenir = "-";
        }
    }
    
}
