import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Scanner;

//interface
public class transaksi implements paket {

    Integer idPendaftar;
    String tanggal;
    Integer nopaket;
    int inputwaktu;
    int nosesi;
    static String paketnya;
    static int harga;
    static String waktu;
    static String sesi;
    static String jam;
    static int totalHarga, biaya1, cash, kembalian,diskon;
    static String metodenya;
    static String jamnya;
    public static int metode;

    static Scanner input = new Scanner(System.in);
    static Scanner inputt = new Scanner(System.in);

    public void NamaPendaftar() {
        System.out.print("> Masukkan Nama Pendaftar       : ");
    }

    public void pkt() {
        String[] nama = { "Kelas 4,5, 6 SD", "Kelas 7, 8, 9 SMP", "Kelas 10,11 SMA", "Kelas 12 SMA & SNBT", "GAP Year" };
        String temp;
        // Mengurutkan nama aplikasi
        System.out.println("\n==================================");
        System.out.println("        !! PAKET !!");
        System.out.println("==================================");
        // Perulangan dengan For
        for (int i = 0; i < (nama.length - 1); i++) {
            for (int j = 0; j < (nama.length - 1); j++) {
                if (nama[j].compareTo(nama[j + 1]) > 0) {
                    temp = nama[j + 1];
                    nama[j + 1] = nama[j];
                    nama[j] = temp;
                }
            }
        }
        for (int i = 0; i < nama.length; i++) {
            System.out.println(i + 1 + " " + nama[i]);
        }
        System.out.print("> Masukkan Paket : ");
        nopaket = input.nextInt();
        input.nextLine();

        // percabangan
        if (this.nopaket == 1) {
            paketnya = "GAP Year Kelas";
        } else if (this.nopaket == 2) {
            paketnya = "Kelas 10,11 SMA";
        } else if (this.nopaket == 3) {
            paketnya = "Kelas 12 SMA & SNBT";
        } else if (this.nopaket == 4) {
            paketnya = "4,5, 6 SD";
        } else if (this.nopaket == 5) {
            paketnya = "Kelas 7, 8, 9 SMP";
        }
    }

    public void wkt() {
        // Collection Framework
        // membuat objek hashmap
        HashMap<Integer, String> jam = new HashMap<Integer, String>();
        jam.put(1, "3-5 Siang");
        jam.put(2, "6-8 Malam");
        jam.put(3, "7-9 Malam");

        System.out.println("\n============================================");
        System.out.println("                WAKTU PEMBELAJARAN   ");
        System.out.println("============================================\n");
        System.out.println(jam);
        System.out.print("> Masukkan waktu pembelajaran : ");
        inputwaktu = input.nextInt();
        input.nextLine();

        // percabangan
        if (inputwaktu == 1) {
            waktu = "3-5 Siang";
        } else if (inputwaktu == 2) {
            waktu = "6-8 Malam";
        } else if (inputwaktu == 3) {
            waktu = "7-9 Malam";
        } else {
            System.out.println("Nomor yang anda masukkan salah");
            System.out.print("> Masukkan no waktu pembelajaran : ");
            inputwaktu = input.nextInt();
            input.nextLine();
        }
    }

    public void kelas() {
        System.out.println("\n==================================");
        System.out.println("            !! JENIS !!");
        System.out.println("==================================");
        System.out.println(" 1. Bersama   ");
        System.out.println(" 2. Private");
        System.out.print("\n > Masukkan jenis : ");
        nosesi = input.nextInt();
        input.nextLine();
        // percabangan if
        if (nosesi == 1) {
            sesi = "Bersama";
        } else if (nosesi == 2) {
            sesi = "Private";
        } else {
            System.out.println("Nomor yang anda masukkan salah");
            System.out.print("\n > Masukkan jenis : ");
            nosesi = input.nextInt();
            input.nextLine();
        }
    }

    public void hrg() {
        int harga[][][] = { 
            // GAP Year Kelas
            { { 9640000, 15000000 }, { 10100000, 17000000 }, { 11000000, 19000000 } },
            // Kelas 10,11 SMA
            { { 5850000, 7800000 }, { 6000000, 8700000 }, { 6500000, 9100000 } },
            // Kelas 12 SMA & SNBT
            { { 8490000, 10360000 }, { 9000000, 11400000 }, { 9500000, 1200000 } },
            // 4,5, 6 SD
            { { 4760000, 6810000 }, { 5000000, 8100000 }, { 5300000, 8600000 } },
            // Kelas 7, 8, 9 SMP
            { { 5850000, 7600000 }, { 6000000, 8600000 }, { 6500000, 9000000 } }
    };    

        // percabangan
        if ((nopaket == 1) && (inputwaktu == 1) && (nosesi == 1)) // Jika nopaket 0 dan inputwaktu 0 dan
                                                                          // nosesi 0
        {
            biaya1 = harga[0][0][0]; // biaya1 menampung harga [0][0][0]
        } else if ((nopaket == 1) && (inputwaktu == 1) && (nosesi == 2)) // Jika nopaket 0 dan inputwaktu 0
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[0][0][1]; // biaya1 menampung harga [0][0][1]
        } else if ((nopaket == 1) && (inputwaktu == 2) && (nosesi == 1)) // Jika nopaket 0 dan inputwaktu 1
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[0][1][0]; // biaya1 menampung harga [0][1][0]
        } else if ((nopaket == 1) && (inputwaktu == 2) && (nosesi == 2)) // Jika nopaket 0 dan inputwaktu 1
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[0][1][1]; // biaya1 menampung harga [0][1][1]
        } else if ((nopaket == 1) && (inputwaktu == 3) && (nosesi == 1)) // Jika nopaket 0 dan inputwaktu 2
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[0][2][0]; // biaya1 menampung harga [0][2][0]
        } else if ((nopaket == 1) && (inputwaktu == 3) && (nosesi == 2)) // Jika nopaket 0 dan inputwaktu 2
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[0][2][1]; // biaya1 menampung harga [0][2][1]
        } else if ((nopaket == 2) && (inputwaktu == 1) && (nosesi == 1)) // Jika nopaket 1 dan inputwaktu 0
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[1][0][0]; // biaya1 menampung harga [1][0][0]
        } else if ((nopaket == 2) && (inputwaktu == 1) && (nosesi == 1)) // Jika nopaket 1 dan inputwaktu 0
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[1][0][1]; // biaya1 menampung harga [1][0][1]
        } else if ((nopaket == 2) && (inputwaktu == 2) && (nosesi == 1)) // Jika nopaket 1 dan inputwaktu 1
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[1][1][0]; // biaya1 menampung harga [1][1][0]
        } else if ((nopaket == 2) && (inputwaktu == 2) && (nosesi == 2)) // Jika nopaket 1 dan inputwaktu 1
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[1][1][1]; // biaya1 menampung harga [1][1][1]
        } else if ((nopaket == 2) && (inputwaktu == 3) && (nosesi == 1)) // Jika nopaket 1 dan inputwaktu 2
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[1][2][0]; // biaya1 menampung harga [1][2][1]
        } else if ((nopaket == 2) && (inputwaktu == 3) && (nosesi == 2)) // Jika nopaket 1 dan inputwaktu 2
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[1][2][1];// biaya1 menampung harga [1][2][1]
        } else if ((nopaket == 3) && (inputwaktu == 1) && (nosesi == 1))// Jika nopaket 2 dan inputwaktu 0
                                                                                // dan nosesi 0
        {
            biaya1 = harga[2][0][0]; // biaya1 menampung harga [2][0][0]
        } else if ((nopaket == 3) && (inputwaktu == 1) && (nosesi == 2)) // Jika nopaket 2 dan inputwaktu 1
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[2][0][1]; // biaya1 menampung harga [2][0][1]
        } else if ((nopaket == 3) && (inputwaktu == 2) && (nosesi == 1)) // Jika nopaket 2 dan inputwaktu 1
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[2][1][0]; // biaya1 menampung harga [2][1][0]
        } else if ((nopaket == 3) && (inputwaktu == 2) && (nosesi == 2)) // Jika nopaket 2 dan inputwaktu 1
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[2][1][1]; // biaya1 menampung harga [2][1][1]
        } else if ((nopaket == 3) && (inputwaktu == 2) && (nosesi == 1)) // Jika nopaket 2 dan inputwaktu 2
                                                                                 // dan nosesi 0
        {
            biaya1 = harga[2][2][0]; // biaya1 menampung harga [2][2][0]
        } else if ((nopaket == 3) && (inputwaktu == 3) && (nosesi == 2)) // Jika nopaket 2 dan inputwaktu 2
                                                                                 // dan nosesi 1
        {
            biaya1 = harga[2][2][1]; // biaya1 menampung harga [2][2][1]
        } else if ((nopaket == 4) && (inputwaktu == 1) && (nosesi == 1)) // Jika nopaket 3 dan inputwaktu 0
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[3][0][0];// biaya1 menampung harga [3][0][0]
        } else if ((nopaket == 4) && (inputwaktu == 1) && (nosesi == 2)) // Jika noaplikasi 3 dan inputwaktu 0
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[3][0][1]; // biaya1 menampung harga [3][0][1]
        } else if ((nopaket == 4) && (inputwaktu == 2) && (nosesi == 1)) // Jika noaplikasi 3 dan inputwaktu 1
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[3][1][0]; // biaya1 menampung harga [3][1][0]
        } else if ((nopaket == 4) && (inputwaktu == 2) && (nosesi == 2)) // Jika noaplikasi 3 dan inputwaktu 1
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[3][1][1]; // biaya1 menampung harga [3][1][1]
        } else if ((nopaket == 4) && (inputwaktu == 3) && (nosesi == 1)) // Jika noaplikasi 3 dan inputwaktu 2
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[3][2][0]; // biaya1 menampung harga [3][2][0]
        } else if ((nopaket == 4) && (inputwaktu == 3) && (nosesi == 2)) // Jika noaplikasi 3 dan inputwaktu 2
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[3][2][1]; // biaya1 menampung harga [3][2][1]
        } else if ((nopaket == 5) && (inputwaktu == 1) && (nosesi == 1)) // Jika noaplikasi 4 dan inputwaktu 0
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[4][0][0]; // biaya1 menampung harga [4][0][0]
        } else if ((nopaket == 5) && (inputwaktu == 1) && (nosesi == 2)) // Jika noaplikasi 4 dan inputwaktu 0
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[4][0][1]; // biaya1 menampung harga [4][0][1]
        } else if ((nopaket == 5) && (inputwaktu == 2) && (nosesi == 1)) // Jika noaplikasi 4 dan inputwaktu 1
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[4][1][0]; // biaya1 menampung harga [4][1][0]
        } else if ((nopaket == 5) && (inputwaktu == 2) && (nosesi == 2)) // Jika noaplikasi 4 dan inputwaktu 1
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[4][1][1]; // biaya1 menampung harga [4][1][1]
        } else if ((nopaket == 5) && (inputwaktu == 3) && (nosesi == 1)) // Jika noaplikasi 4 dan inputwaktu 2
                                                                                 // dan nopemakaian 0
        {
            biaya1 = harga[4][2][0]; // biaya1 menampung harga [4][2][0]
        } else if ((nopaket == 5) && (inputwaktu == 3) && (nosesi == 2)) // Jika noaplikasi 4 dan inputwaktu 2
                                                                                 // dan nopemakaian 1
        {
            biaya1 = harga[4][2][1];// biaya1 menampung harga [4][2][1]
        }
        System.out.print(" Total harga : Rp. " + biaya1);
        System.out.println("");
    }

    // string dan Date
    public String Tanggal() {
        LocalDate date = LocalDate.now();
        DateTimeFormatter frmt = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        this.tanggal = date.format(frmt);
        return this.tanggal;
    }

    @Override
    public void MetodePembayaran() {
    }
}
