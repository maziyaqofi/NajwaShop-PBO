// Maziya Ats Tsaqofi
// 21 April 2025
// MID Exam - Pemrograman Berorientasi Objek

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppToko {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Masukkan jumlah barang: ");
        int jumlah = in.nextInt();
        in.nextLine(); // konsumsi newline

        Toko[] dataBarang = new Toko[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nData ke-" + (i + 1));
            dataBarang[i] = new Toko();
            dataBarang[i].inputBarang();
            dataBarang[i].tentukanSouvenir();
        }

        // Header tabel
        System.out.println("\nDAFTAR BARANG LENGKAP");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-8s %-10s %-10s %-10s %-12s %-15s%n",
                "No Nota", "Barcode", "Nama", "Hrg Jual", "Jumlah", "Total", "PPN", "Bunga", "Tot Bayar", "Metode", "Souvenir");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------");

        double totalSeluruh = 0;
        for (Toko t : dataBarang) {
            System.out.printf("%-10s %-10s %-10s %-10.2f %-10d %-8.2f %-10.2f %-10.2f %-10.2f %-12s %-15s%n",
                    t.noNota, t.barCode, t.nmBarang, t.hrgJual, t.jumlah, t.total, t.ppn, t.bunga, t.grandTotal, t.metodeBayar, t.souvenir);
            totalSeluruh += t.grandTotal;
        }

        System.out.printf("\nTOTAL SELURUH PEMBAYARAN: Rp %.2f\n", totalSeluruh);

        // Simpan ke file nota_transaksi.txt
        try {
            FileWriter writer = new FileWriter("nota_transaksi.txt");
            writer.write("NOTA TRANSAKSI BARANG\n\n");
            writer.write(String.format("%-10s %-10s %-10s %-10s %-10s %-8s %-10s %-10s %-10s %-12s %-15s%n",
                    "No Nota", "Barcode", "Nama", "Hrg Jual", "Jumlah", "Total", "PPN", "Bunga", "Tot Bayar", "Metode", "Souvenir"));
            writer.write("------------------------------------------------------------------------------------------------------------------------------------------\n");

            for (Toko t : dataBarang) {
                writer.write(String.format("%-10s %-10s %-10s %-10.2f %-10d %-8.2f %-10.2f %-10.2f %-10.2f %-12s %-15s%n",
                        t.noNota, t.barCode, t.nmBarang, t.hrgJual, t.jumlah, t.total, t.ppn, t.bunga, t.grandTotal, t.metodeBayar, t.souvenir));
            }

            writer.write("\nTOTAL SELURUH PEMBAYARAN: Rp " + String.format("%.2f", totalSeluruh));
            writer.close();

            System.out.println("\nNota transaksi berhasil disimpan di 'nota_transaksi.txt'");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan file: " + e.getMessage());
        }

        in.close();
    }
}
