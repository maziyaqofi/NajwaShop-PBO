import java.util.Scanner;

// Maziya Ats Tsaqofi
// 21 April 2025
// MID EXAM - Pemrograman Berorientasi Objek

public class Barang {
    // Atribut barang dan transaksi
    String noNota;
    String barCode;
    String nmBarang;
    double hrgBeli;
    double hrgJual;
    int jumlah;
    double total;
    String metodeBayar;
    int lamaTempo;
    double ppn;
    double bunga;
    double beaKartu;
    double grandTotal;
    String souvenir;


    Scanner input = new Scanner(System.in);

    // Method input data barang dan transaksi
    void inputBarang() {
        System.out.print("Masukkan No Nota         : ");
        noNota = input.nextLine();

        System.out.print("Masukkan Barcode         : ");
        barCode = input.nextLine();

        System.out.print("Masukkan Nama Barang     : ");
        nmBarang = input.nextLine();

        System.out.print("Masukkan Harga Beli      : ");
        hrgBeli = input.nextDouble();

        // Hitung harga jual berdasarkan ketentuan
        if (hrgBeli > 500000) {
            hrgJual = hrgBeli * 1.10;
        } else if (hrgBeli > 200000) {
            hrgJual = hrgBeli * 1.25;
        } else if (hrgBeli > 100000) {
            hrgJual = hrgBeli * 1.50;
        } else if (hrgBeli > 50000) {
            hrgJual = hrgBeli * 1.75;
        } else {
            hrgJual = hrgBeli * 2.00;
        }

        System.out.print("Masukkan Jumlah Barang   : ");
        jumlah = input.nextInt();

        total = hrgJual * jumlah;

        input.nextLine(); // bersihkan newline
        System.out.print("Masukkan Metode Bayar (cash/debet/tempo): ");
        metodeBayar = input.nextLine().toLowerCase();

        ppn = 0.11 * total;

        if (metodeBayar.equals("tempo")) {
            System.out.print("Masukkan Lama Tempo (hari): ");
            lamaTempo = input.nextInt();
            input.nextLine(); // bersihkan newline
            bunga = (lamaTempo > 14) ? 0.025 * total : 0;
        } else {
            bunga = 0;
            lamaTempo = 0;
        }

        beaKartu = metodeBayar.equals("debet") ? 1000 : 0;

        grandTotal = total + ppn + bunga + beaKartu;
    }
}
